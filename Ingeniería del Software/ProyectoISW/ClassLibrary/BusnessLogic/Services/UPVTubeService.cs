using UPVTube.Entities;
using UPVTube.Persistence;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Services
{
    public class UPVTubeService : IUPVTubeService
    {
        private readonly IDAL dal;
        private Member User;

        public Member getUser() => User;
        public void setUser(Member user) => User = user;
        public UPVTubeService(IDAL dal)
        {
            this.dal = dal;
        }

        public void RemoveAllData()
        {
            dal.RemoveAllData();
        }

        public void Commit()
        {
            dal.Commit();
        }
        
        public void DBInitialization()
        {
            RemoveAllData();

            Subject s1 = new Subject("11555", "Ingeniería del software", "ISW");
            AddSubject(s1);
            Subject s2 = new Subject("11553", "Arquitectura e ingeniería de computadores", "AIC");
            AddSubject(s2);
            Subject s3 = new Subject("11548", "Bases de datos y sistemas de información", "BDA");
            AddSubject(s3);
            Subject s4 = new Subject("11560", "Sistemas inteligentes", "SIN");
            AddSubject(s4);

            // Añadir los 3 miembros
            Member m1 = new Member("manolitokk@inf.upv.es", "Manolito kaka", DateTime.Now, "Mkk", "mkk1234");
            Registrarse(m1);
            Member m2 = new Member("gerarhervas@dsica.upv.es", "Gerardo Hervas", DateTime.Now, "Patiti_Kawai_23", "gh1234");
            Registrarse(m2);
            Member m3 = new Member("jorgerumtorre@dsic.upv.es", "Jorge Rumualdo de la Torre", DateTime.Now, "Traspas", "jrt1234");
            Registrarse(m3);
            // Añadir los 4 contenidos
            Content c1 = new Content("Video_1", "Video de como seleccionar correctamente los datos para un sistema de BBDD", true, "BDA-T304", DateTime.Now, m3);
            SubirContenido(c1);
            Content c2 = new Content("Video_2", "Correccion del examen 2022", true, "ISW EXAMEN 2022", DateTime.Now, m2);
            SubirContenido(c2);
            Content c3 = new Content("Video_3", "Hardware optimizado para el funcionamiento de las IA de aprendizage no supervisado", true, "Hardware para IA", DateTime.Now, m3);
            SubirContenido(c3);
            Content c4 = new Content("Video_4", "Critica no constructiva de la UPV", true, "Critica sin motivo a la upv", DateTime.Now, m1);
            SubirContenido(c4);
        }

        public void AddSubject(Subject subject)
        {
            // Restricción: No puede haber dos asignaturas con el mismo code
            if (dal.GetById<Subject>(subject.Code) == null)
            {
                // Restricción: No puede haber dos asignaturas con el mismo name
                if (!dal.GetWhere<Subject>(x => x.Name == subject.Name).Any())
                {
                    // Sólo se salva si no hay Code ni email duplicado
                    dal.Insert<Subject>(subject);
                    dal.Commit();
                }
                else
                    throw new ServiceException("Subject with name " + subject.Name + " already exists.");
            }
            else
                throw new ServiceException("Subject with code " + subject.Code + " already exists.");
        }

        // A partir de aquí los métodos para implementar los CU

        public void Registrarse(Member m)
        {
            if (dal.Exists<Member>(m.Nick)) throw new ServiceException("Nickname ya en uso");
            if (dal.GetWhere<Member>(n => n.Email == m.Email).ToList().Count > 0) throw new ServiceException("Email en uso");
            dal.Insert(m); 
            dal.Commit();
            setUser(m);
        }
    
        public void Login(String nick, String password) 
        {
            if (!dal.Exists<Member>(nick)) throw new ServiceException("El usuario NO existe");
            Member m = dal.GetById<Member>(nick);

            if (!m.Password.Equals(password)) throw new ServiceException("Contraseña incorrecta");
            setUser(m);
        }

        public void Logout()
        {
            if (User == null) throw new ServiceException("No hay ningun usuario activo");
            User.LastAccessDate = DateTime.Now;
            setUser(null);
        }

        public void SubirContenido(Content contenido) {
            if (contenido.ContentURI == null || contenido.ContentURI.Equals("")) throw new ServiceException("Conntent without contentURI");
            if (contenido.Description == null) throw new ServiceException("Conntent without description");
            if (contenido.Title == null || contenido.Title.Equals("")) throw new ServiceException("Conntent without tittle");
            if (contenido.IsPublic == null) throw new ServiceException("Contnent without isPublic set"); 
            contenido.UploadDate = DateTime.Now;

            dal.Insert<Content>(contenido);
            User.Contents.Add(contenido);
            dal.Commit();
        }

        public void VerContenido(Content contenido)
        {
            if(contenido == null) throw new ServiceException("No se ha seleccionado ningun contenido");
            // falta crear una visualizacion
            Visualization v = new Visualization(DateTime.Now,contenido,User);
            dal.Insert(v);
            contenido.Visualizations.Add(v);
            dal.Commit();
            //String[] x = { contenido.Title, contenido.Owner.Nick, contenido.Description, contenido.UploadDate.ToString(), contenido.ContentURI };
        }
        
        public IEnumerable<Content> BuscarContenido(DateTime inicioBusqueda, DateTime finBusqueda, String nickCreador = "", String title = "", Authorized authorized = Authorized.Yes, Subject subject = null) {
            /*
             * IEnumerable<Content> contenido = dal.GetAll<Content>();
            // La fecha de inicio de busqueda debe ser anterior (o igual) a la fecha de fin
            if (inicioBusqueda > finBusqueda) throw new ServiceException("inicioBusqueda debe ser anterior a finBusqueda");

            
             // Filtra según los parámetros proporcionados y almacena el resultado,
            // ordenado por fecha de subida, en `contents`
            IEnumerable<Content> contents = dal.GetWhere<Content>(content =>
                (inicioBusqueda == null || content.UploadDate >= inicioBusqueda) && // Filtra por inicio de busqueda o pasa al siguiente filtro si inicioBusqueda es null
                (finBusqueda == null || content.UploadDate <= finBusqueda) && // idem
                (nickCreador == null || content.Owner.Nick.Equals(nickCreador)) && // idem
                (palabras == null ||content.Title.Contains(palabras)) && // idem
                (Subject == null || content.Subjects.Contains(Subject)) // idem
            ).OrderBy(content => content.UploadDate); // ordena por fecha de subida
             */

            IEnumerable<Content> contents = dal.GetWhere<Content>(c => c.Authorized == authorized);

            if (inicioBusqueda != null || finBusqueda != null)
            { // hay que modificarlo
                if (inicioBusqueda >= finBusqueda) throw new ServiceException("Fechas de la busqueda incorrectas");
                contents = contents.Where<Content>(c => c.UploadDate.CompareTo(inicioBusqueda)>= 0 && c.UploadDate.CompareTo(finBusqueda) <= 0);
            }

            if (!nickCreador.Equals(""))
            {
                if (!dal.Exists<Member>(nickCreador)) throw new ServiceException("No existe el usuario seleccionado");
                contents = contents.Where<Content>(c => c.Owner.Nick.Equals(nickCreador));
            }

            if (!title.Equals(""))
            {
                contents = contents.Where<Content>(c => c.Title.Contains(title));
            }

            if (subject != null)
            {
                if (!dal.Exists<Subject>(subject.Code)) throw new ServiceException("No existe el usuario seleccionado");
                contents = contents.Where<Content>(c => c.Subjects.Contains(subject));
            }

            // Devuelve la lista
            return contents.OrderBy(content => content.UploadDate);
        }

        public void EvaluarContenido(Content c, Authorized authorized, string comment, Member censor) 
        {
            Evaluation ev = new Evaluation(DateTime.Now, comment, censor, c);
            if(authorized == Authorized.No) dal.Insert(ev);

            c.Authorized = authorized;
            dal.Commit();
        }

        // Extras necesarios para la APP

        public IEnumerable<Subject> getAllSubjects()
        {
            return dal.GetAll<Subject>();
        }
        public Subject getSubject(string subjectName)
        {
            if (subjectName == "") return null;
            return dal.GetById<Subject>(subjectName);
        }
        public Content getContent(int id)
        {
            if (id <1) return null;
            return dal.GetById<Content>(id);
        }
        public void comentar(Comment c)
        {
            dal.Insert(c);
            dal.Commit();
        }
        public void Suscribe(Member pub)
        {
            pub.Subscriptors.Add(User);
            User.SubscribedTo.Add(pub);
            dal.Commit();
        }
        public void desuscribe(Member pub)
        {
            pub.Subscriptors.Remove(User);
            User.SubscribedTo.Remove(pub);
            dal.Commit();
        }
        public void Modify(String Email, String FullName, DateTime LastAccessDate, String Nick, String Password)
        {
            this.User.Email = Email;
            this.User.FullName = FullName;
            this.User.LastAccessDate = LastAccessDate;
            this.User.Nick = Nick;
            this.User.Password = Password;
            dal.Commit();
        }
        public bool DBIsEmpty()
        {
            if(dal.GetAll<Content>().Count() > 0)          return false;
            if(dal.GetAll<Comment>().Count() > 0)          return false;
            if(dal.GetAll<Evaluation>().Count() > 0)       return false;
            if(dal.GetAll<Member>().Count() > 0)           return false;
            if(dal.GetAll<Subject>().Count() > 0)          return false;
            if(dal.GetAll<Visualization>().Count() > 0)    return false;
            return true;
        }
    }
}
