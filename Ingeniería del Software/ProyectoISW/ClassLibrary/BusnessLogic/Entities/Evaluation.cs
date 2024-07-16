using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Evaluation
    {
        public Evaluation() { }

        public Evaluation(DateTime EvaluationDate, String RejectionReason, Member Censor, Content Content) { 
            this.Content = Content;
            this.Censor = Censor;
            this.EvaluationDate=EvaluationDate;
            this.RejectionReason=RejectionReason;
        }

    }
}
