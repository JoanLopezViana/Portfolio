using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace UPVTube.Entities
{
    public partial class Content
    {
        public Content()
        {
            this.Visualizations = new List<Visualization>();
            this.Comments = new List<Comment>();
            this.Subjects = new List<Subject>();
        }
        public Content(String ContentURI,String Description, Boolean IsPublic, 
            String Title,DateTime UploadDate, Member Owner):this()
        {
            this.ContentURI = ContentURI;
            this.Description = Description;
            this.IsPublic = IsPublic;
            this.Title = Title;
            this.UploadDate = UploadDate;
            this.Owner = Owner;
            if( Owner.IsTeacher() )
            {
                this.Authorized = Authorized.Yes;
            }
            else
            {
                this.Authorized = Authorized.Pending;
            }
        }
    }
}
