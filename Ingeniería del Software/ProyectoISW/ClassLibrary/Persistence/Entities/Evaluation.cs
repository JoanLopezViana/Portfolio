using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Evaluation
    {
        public DateTime EvaluationDate { get; set; }
        public int Id { get; set; }
        public String RejectionReason { get; set; }
        [Required]
        public virtual Content Content { get; set; }
        [Required]
        public virtual Member Censor { get; set; }
       
    }
}
