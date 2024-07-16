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
using UPVTube.Entities;

namespace UPVTube.GUI
{
    public partial class EvaluarContenido : Form
    {
        private IUPVTubeService service;
        private UPVTubeApp upvtube;
        private Content content;

        public EvaluarContenido(IUPVTubeService service, Content content)
        {
            InitializeComponent();
            this.service = service;
            // TODO: Get content to evaluate
            // this.content = upvtube.content;
            this.content = content;//new Content("dummy_uri", "Dummy description", false, "Dummy title", DateTime.Now, service.getUser());
            AlumnoTextBox.Text = content.Owner.FullName;
            DescripcionTextBox.Text = content.Description;
            TituloTextBox.Text = content.Title;
            FechaSubidaTextBox.Text = content.UploadDate.ToString();

            List<Subject> subjects = content.Subjects.ToList();
            // Build the subjects string
            string subjectsString = "";
            for (int i = 0; i < subjects.Count; i++)
            {
                subjectsString += subjects[i].FullName + " ";
            }
            // Display the subjects string
            AsignaturasTextBox.Text = subjectsString;
        }

        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;

        private void ConfirmarButton_Click(object sender, EventArgs e)
        {
            try
            {
                Authorized state = Authorized.Yes;
                if (DeclineButton.Checked) { state = Authorized.No; }
                service.EvaluarContenido(content, state, CommentTBox.Text, service.getUser());
                BuscarContenidoEvaluar f1 = new BuscarContenidoEvaluar(service);
                f1.AsignarMain(upvtube);
                upvtube.Navegar(f1);
                MessageBox.Show("Contenido evaluado correctamente", "Success",
                                MessageBoxButtons.OK, MessageBoxIcon.Information);
            }catch(Exception ex)
            {
                MessageBox.Show("Error durante la evaluación. Mensaje de error: \n" + ex.Message, "Error",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
        }
    }
}
