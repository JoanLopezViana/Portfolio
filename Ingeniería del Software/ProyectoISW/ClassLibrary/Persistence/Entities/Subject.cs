using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Subject
    {
        public String FullName { get; set; }
        [DatabaseGeneratedAttribute(DatabaseGeneratedOption.None), Key()]
        public string Code { get; set; }
        public String Name { get; set; }

        //--------------------RELACIONES--------------------//

        public virtual ICollection<Content> Contents { get; set; }
    }
}
