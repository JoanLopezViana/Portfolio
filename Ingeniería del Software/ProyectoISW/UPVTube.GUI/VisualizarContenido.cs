using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UPVTube.Services;

namespace UPVTube.GUI
{
    public partial class VisualizarContenido : Form
    {
        Entities.Content video;
        IUPVTubeService service;
        private UPVTubeApp upvtube;
        public VisualizarContenido(IUPVTubeService service, Entities.Content video)
        {
            InitializeComponent();
            this.video = video;
            this.service = service;
            titleV.Text = video.Title;
            descriptV.Text = "URI: " + video.ContentURI + "\n\nCreador: "+ video.Owner.Nick + "\n\nDescripcion:\n" + video.Description;
            service.VerContenido(video);
            UpdateComment();
            if (service.getUser().SubscribedTo.Contains(video.Owner))
            {
                suscribeButton.Text = "Suscrito";
            }
            else
            {
                suscribeButton.Text = "Suscribirse";
            }
            int w = listaVideos.Width/100 * 95;
            listaVideos.Columns[0].Width = w/3;
            listaVideos.Columns[1].Width = w/3 * 2;
        }
    
        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;
        private void UpdateComment()
        {
            
            IEnumerator<Entities.Comment> c = video.Comments.GetEnumerator();
            Entities.Comment videoComment;
            while (c.MoveNext())
            {
                videoComment = c.Current;
                AddComent(videoComment);
            }
        }
        private void AddComent(Entities.Comment c)
        {
            ListViewItem comentAct;
            comentAct = new ListViewItem(c.Writer.Nick);
            comentAct.SubItems.Add(c.Text);
            listaVideos.Items.Add(comentAct);
        }
        private void addComment_Click(object sender, EventArgs e)
        {
            Entities.Comment comentario = new Entities.Comment(newComent.Text, DateTime.Now, video, service.getUser());
            service.comentar(comentario);
            AddComent(comentario);
            newComent.Text = "";
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void suscribeButton_Click(object sender, EventArgs e)
        {
            if (service.getUser().SubscribedTo.Contains(video.Owner))
            {
                service.desuscribe(video.Owner);
                suscribeButton.Text = "Suscribirse";
            }
            else
            {
                service.Suscribe(video.Owner);
                suscribeButton.Text = "Suscrito";
            }
            upvtube.loadSuscripciones();
        }

    }
}
