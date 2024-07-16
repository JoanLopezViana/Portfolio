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
    public partial class Historial : Form
    {
        private IUPVTubeService service;
        private UPVTubeApp upvtube;

        public Historial(IUPVTubeService service)
        {
            InitializeComponent();

            // Agrega las columnas al ListView
            historial1.Columns.Add("ContentURI", 150);
            historial1.Columns.Add("Title", 150);
            historial1.Columns.Add("Owner", 150);

            this.service = service;

            // Después de agregar las columnas, llama a actualizeList
           IEnumerable<Entities.Visualization> contenidos = service.getUser().Visualizations;
            actualizeList(contenidos);
        }

        private void actualizeList(IEnumerable<Entities.Visualization> c)
        {
            //historial.Items.Clear();
            IEnumerator<Entities.Visualization> iter = c.GetEnumerator();
            ListViewItem video;
            Entities.Visualization actual;
            while (iter.MoveNext())
            {
                actual = iter.Current;
                video = new ListViewItem(actual.Content.ContentURI);
                video.SubItems.Add(actual.Content.Title);
                video.SubItems.Add(actual.Content.Owner.Nick);
                video.SubItems.Add(actual.Content.Id.ToString());
                historial1.Items.Add(video);
                iter.MoveNext();
            }
        }
        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;

        private void Historial_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
