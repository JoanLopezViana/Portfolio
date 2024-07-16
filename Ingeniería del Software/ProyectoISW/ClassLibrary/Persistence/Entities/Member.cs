using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Member
    {
        //[DatabaseGeneratedAttribute(DatabaseGeneratedOption.None),Key()]
        public String Email { get; set; }
        public String FullName { get; set; }
        public DateTime LastAccessDate { get; set; }
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.None), Key()]
        public String Nick { get; set; }
        public String Password { get; set; }



        //----------RELACIONES----------
        static private List<String> TeacherDomains = new List<string> { "@dsic.upv.es", "@dsica.upv.es" };
        static private List<String> StudentDomains = new List<string> { "@inf.upv.es" };
        
        public virtual List<Evaluation> Evaluations { get; set; }
        [InverseProperty("SubscribedTo")]
        public virtual List<Member> Subscriptors { get; set; }
        [InverseProperty("Subscriptors")]
        public virtual List<Member> SubscribedTo { get; set; }
        public virtual List<Visualization> Visualizations { get; set; }
        public virtual List<Comment> Comments { get; set; }
        public virtual List<Content> Contents { get; set; }


    }
}
