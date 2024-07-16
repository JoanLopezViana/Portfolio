using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UPVTube.Entities;


namespace UPVTube.Services
{
    public interface IUPVTubeService
    {
        void RemoveAllData();
        void Commit();

        // Necesario para la inicialización de la BD
        void DBInitialization();
        void AddSubject(Subject subject);

        //
        // A partir de aquí los necesarios para los CU solicitados
        //

        void Registrarse(Member m);
        void Login(String nick, String password);
        void Logout();
        void SubirContenido(Content contenido);
        IEnumerable<Content> BuscarContenido(DateTime inicioBusqueda, DateTime finBusqueda, 
            String nickCreador = "", String title = "", Authorized authorized = Authorized.Yes, Subject Subject = null);
        void VerContenido(Content contenido);
        void EvaluarContenido(Content contenido, Authorized authorized, string comment, Member censor);

        // Extras necesarios para la APP
        IEnumerable<Subject> getAllSubjects();
        Subject getSubject(string subjectName);
        Content getContent(int id);
        Member getUser();
        void Modify(String Email, String FullName, DateTime LastAccessDate, String Nick, String Password);
        void comentar(Comment com);
        void Suscribe(Member pub);
        void desuscribe(Member pub);

        bool DBIsEmpty();
    }
}
