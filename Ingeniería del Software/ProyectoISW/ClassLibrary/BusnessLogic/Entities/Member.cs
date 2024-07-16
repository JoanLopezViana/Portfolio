using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Member
    {
        public Member() {
            this.Evaluations = new List <Evaluation>();
            this.Subscriptors = new List<Member>();
            this.SubscribedTo = new List<Member>();
            this.Visualizations = new List<Visualization>();
            this.Comments = new List<Comment>();
            this.Contents = new List<Content>();
        }
        public Member(String Email, String FullName, DateTime LastAccessDate, String Nick, String Password):this() {
            this.Email = Email;
            this.FullName = FullName;
            this.LastAccessDate = LastAccessDate;
            this.Nick = Nick;
            this.Password = Password;
        }


        //Método de add y set-------------------------------------------------------------------------
        /*
        public void addToEvaluations(String toAdd) => this.Evaluations.add(toAdd);
        public void addToSubscriptors(String toAdd) => this.Subscriptors.add(toAdd);
        public void addToSubscribedTo(String toAdd) => this.SubscribedTo.add(toAdd);
        public void addToVisualizations(String toAdd) => this.Visualizations.add(toAdd);
        public void addToComments(String toAdd) => this.Comments.add(toAdd);
        public void addToContents(String toAdd) => this.Contents.add(toAdd);
        */
        public void AddContent(Content content)
        {
            this.Contents.Add(content);
        }
        public void Modify(String Email, String FullName, DateTime LastAccessDate, String Nick, String Password) {
            this.Email = Email;
            this.FullName = FullName;
            this.LastAccessDate = LastAccessDate;
            this.Nick = Nick;
            this.Password = Password;

        }

        //Métodos otros
        public bool IsStudent()
        {
            foreach (String alias in StudentDomains)
                if (Email.Contains(alias)) return true;
            return false;
        }
        public bool IsTeacher()
        {
            foreach (String alias in TeacherDomains)
                if (Email.Contains(alias)) return true;
            return false;
        }
    }
}
