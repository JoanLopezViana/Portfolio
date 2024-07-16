using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Comment
    {
        public int Id { get; set; }
        public String Text { get; set; }
        public DateTime WritingDate { get; set; }


        //--------------------RELACIONES--------------------//
        [Required]
        public virtual Member Writer { get; set; }
        [Required]
        public virtual Content Content { get; set; }
    }
}
