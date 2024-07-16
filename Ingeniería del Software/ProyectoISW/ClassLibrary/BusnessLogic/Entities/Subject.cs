using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Subject
    {
        public Subject() 
        {
            this.Contents = new List<Content>();
        }
        public Subject(string Code, String FullName, String Name) : this()
        {
            this.Code = Code;
            this.FullName = FullName;
            this.Name = Name;
        }
    }
}
