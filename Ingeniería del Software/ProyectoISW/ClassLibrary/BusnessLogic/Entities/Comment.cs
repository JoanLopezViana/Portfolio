using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Comment
    {
        public Comment() { }

        public Comment(String Text, DateTime WritingDate, Content Content, Member Writer) { 
            this.Text = Text;
            this.WritingDate = WritingDate;
            this.Content = Content;
            this.Writer = Writer;
        }
    }
}
