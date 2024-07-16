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
    public partial class BuscarContenidoEvaluar : Form
    {
        private IUPVTubeService service;
        private UPVTubeApp upvtube;
        public BuscarContenidoEvaluar(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;
            endDateSearch.Value = DateTime.Now;
            iniDateSearch.Value = DateTime.Now.AddDays(-1);
            iniDateSearch.MaxDate = endDateSearch.Value;
            endDateSearch.MaxDate = DateTime.Now;
            //ImageList imageList = new ImageList();

            //imageList.Images.Add("Play", "C:\\Users\\alexr\\source\\repos\\ProyectoISW\\ProyectoISW\\UPVTube.GUI\\Resources\\Imagen de WhatsApp 2023-12-19 a las 16.09.42_87c69d70.jpg");
            IEnumerable<Entities.Subject> subjects = service.getAllSubjects();
            for (int i = 0; i < subjects.Count(); i++)
            {
                subjectSearch.Items.Add(subjects.ElementAt(i).FullName);
            }

            IEnumerable<Entities.Content> contenidos = service.BuscarContenido(DateTime.MinValue, DateTime.MaxValue,"","",Entities.Authorized.Pending);
            actualizeList(contenidos);
        }
        private void actualizeList(IEnumerable<Entities.Content> c)
        {
            listaVideos.Items.Clear();
            IEnumerator<Entities.Content> iter = c.GetEnumerator();
            ListViewItem video;
            Entities.Content actual;
            while (iter.MoveNext())
            {
                actual = iter.Current;
                video = new ListViewItem(actual.ContentURI);
                video.SubItems.Add(actual.Title);
                video.SubItems.Add(actual.Owner.Nick);
                video.SubItems.Add(actual.Id.ToString());
                listaVideos.Items.Add(video);
            }
            int w = listaVideos.Width - 40;
            listaVideos.Columns[0].Width = 120;
            listaVideos.Columns[2].Width = 120;
            listaVideos.Columns[1].Width = w - 240;
        }
        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;

        private void Buscar_Click(object sender, EventArgs e)
        {
            try
            {
                actualizeList(service.BuscarContenido(iniDateSearch.Value, endDateSearch.Value, makerSearch.Text, paternSearch.Text, Entities.Authorized.Pending, service.getSubject(subjectSearch.Text)));
            }
            catch (Exception ex)
            {
                InformacionError error = new InformacionError(ex);
                error.ShowDialog();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            advancedSearch.Visible = !advancedSearch.Visible;
            if (!advancedSearch.Visible)
            {
                listaVideos.Size = new Size(listaVideos.Width, listaVideos.Height + advancedSearch.Height);
                listaVideos.Location = new Point(listaVideos.Left, listaVideos.Top - advancedSearch.Height);
            }
            else
            {
                listaVideos.Size = new Size(listaVideos.Width, listaVideos.Height - advancedSearch.Height);
                listaVideos.Location = new Point(listaVideos.Left, listaVideos.Top + advancedSearch.Height);
            }
        }

        private void endDateSearch_ValueChanged(object sender, EventArgs e)
        {
            if (iniDateSearch.Value >= endDateSearch.Value) iniDateSearch.Value = endDateSearch.Value.AddDays(-1);
            iniDateSearch.MaxDate = endDateSearch.Value;
        }

        private void listaVideos_SelectedIndexChanged(object sender, EventArgs e)
        {
            ListViewItem v = listaVideos.SelectedItems[0];
            int id = int.Parse(v.SubItems[3].Text);
            EvaluarContenido video = new EvaluarContenido(service, service.getContent(id));
            video.AsignarMain(upvtube);
            upvtube.Navegar(video);
        }
    }
}
