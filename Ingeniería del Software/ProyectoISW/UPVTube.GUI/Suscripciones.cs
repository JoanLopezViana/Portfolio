using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UPVTube.Services;

namespace UPVTube.GUI
{
    public partial class Suscripciones : Form
    {
        private IUPVTubeService service;
        private UPVTubeApp upvtube;
        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;

        public Suscripciones(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;
            Sus.Columns.Add("Nick", 60);
            Sus.Columns.Add("Full Name", 100);
            //Sus.Columns.Add("Email", 150);
            //Sus.Columns.Add("Foto", 150);
            IEnumerable<Entities.Member> contenidos = service.getUser().SubscribedTo;
            actualizeList(contenidos);

        }
        private void actualizeList(IEnumerable<Entities.Member> c)
        {
            Sus.Items.Clear();
            IEnumerator<Entities.Member> iter = c.GetEnumerator();
            ListViewItem video;
            Entities.Member actual;
            while (iter.MoveNext())
            {
                actual = iter.Current;
                video = new ListViewItem(actual.Nick);
                video.SubItems.Add(actual.FullName);
                video.SubItems.Add(actual.Email);
                //video.SubItems.Add(Image.FromFile(""));
                Sus.Items.Add(video);
            }
            //int w = Sus.Width - 40;
            //Sus.Columns[0].Width = 30;
            //Sus.Columns[2].Width = 30;
            //Sus.Columns[1].Width = w - 30;

        }
    }
}