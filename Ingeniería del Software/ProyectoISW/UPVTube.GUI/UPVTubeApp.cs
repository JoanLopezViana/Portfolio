using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UPVTube.Entities;
using UPVTube.Services;

namespace UPVTube.GUI
{
    public partial class UPVTubeApp : Form
    {
        private IUPVTubeService service;
        private Form activeForm = null;
        private MainFrame mainFrame;
        private List<Content> Historialreg= new List<Content> { };
        private bool MenuOpen = true;
        public UPVTubeApp(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;
            loadSuscripciones();
            EvaluarContenidoButton.Visible = service.getUser().IsTeacher();
            SubirContenidoButton.Visible = service.getUser().IsTeacher() ||
                                           service.getUser().IsStudent();
            MenuTransition.Start();
            NavegarHome(null,null); //Para no hacer otro método uwu
        }


        //=========================================================================
        //INICIALIZAR VARIABLES
        public void setMainFrame(MainFrame mf) => mainFrame = mf;
        //=========================================================================
        //SUSCRIPCIONES
        public List<UPVTube.Entities.Content> getHistorial() { return Historialreg; }
        public void AddHistorial(UPVTube.Entities.Content c) { Historialreg.Add(c);  }
        public void loadSuscripciones()
        {
            Suscripciones Sus = new Suscripciones(service);
            Sus.TopLevel = false;
            Sus.FormBorderStyle = FormBorderStyle.None;
            Sus.Dock = DockStyle.Fill;
            panelSuscripciones.Controls.Add(Sus);
            panelSuscripciones.Tag = Sus;
            Sus.BringToFront();
            Sus.Show();
        }
        //=========================================================================
        //NAVEGACIÓN MENÚ
        public void Navegar(Form Form)
        {
            if (activeForm != null)
                activeForm.Close();
            Form.TopLevel = false;
            Form.FormBorderStyle = FormBorderStyle.None;
            Form.Dock = DockStyle.Fill;
            panel1.Controls.Add(Form);
            panel1.Tag = Form;
            Form.BringToFront();
            Form.Show();
            activeForm = Form;
        }
        public void enableAll()
        {
            HomeButton.Enabled = true;
            SubirContenidoButton.Enabled = true;
            EvaluarContenidoButton.Enabled = true;
            PerfilButton.Enabled = true;
            HistorialButton.Enabled = true;
        }

        private void NavegarHome(object sender, EventArgs e)
        {
            enableAll();
            if (MenuOpen) MenuToggle(null, null);
            HomeButton.Enabled = false;
            Vercontenido f1 = new Vercontenido(service);
            f1.AsignarMain(this);
            Navegar(f1);
        }

        private void NavergarSubirContenido(object sender, EventArgs e)
        {
            enableAll(); 
            if (MenuOpen) MenuToggle(null, null);
            SubirContenidoButton.Enabled = false;
            SubirContenido f1 = new SubirContenido(service);
            f1.AsignarMain(this);
            Navegar(f1);
        }

        private void NavergarBuscarContenidoEvaluar(object sender, EventArgs e)
        {
            enableAll(); 
            if (MenuOpen) MenuToggle(null, null);
            EvaluarContenidoButton.Enabled = false;
            if (!service.getUser().IsTeacher()) return;
            BuscarContenidoEvaluar f1 = new BuscarContenidoEvaluar(service);
            f1.AsignarMain(this);
            Navegar(f1);
        }

        private void NavegarPerfil(object sender, EventArgs e)
        {
            enableAll();
            if (MenuOpen) MenuToggle(null, null);
            PerfilButton.Enabled = false;
            Perfil f1 = new Perfil(service);
            f1.AsignarMain(this);
            Navegar(f1);
        }

        private void NavegaHistorial(object sender, EventArgs e)
        {
            enableAll(); 
            if(MenuOpen) MenuToggle(null, null);
            HistorialButton.Enabled = false;
            Historial f1 = new Historial(service);
            f1.AsignarMain(this);
            Navegar(f1);
        }

        private void NavegarLogOut(object sender, EventArgs e)
        {
            DialogResult resultado = MessageBox.Show("¿Estás seguro de que quieres salir?", "¿Salir?", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            // Verificar la respuesta del usuario
            if (resultado == DialogResult.Yes)
            {
                mainFrame.logOut();
            }
        }
        private void MenuToggle(object sender, EventArgs e)
        {
            MenuTransition.Start();
        }
        private void MenuTransition_Tick(object sender, EventArgs e)
        {
            int expand = 20;
            if (!MenuOpen) //Abrir menú
            {
                Suscripciones.Visible = true;
                panelSuscripciones.Visible = true;
                menuPanel.Width += expand;
                if(menuPanel.Width >= 220)
                {
                    MenuTransition.Stop();
                    MenuOpen = true;
                }
            }
            else //Cerrar menú
            {
                menuPanel.Width -= expand;
                if (menuPanel.Width <= 60)
                {
                    MenuTransition.Stop();
                    Suscripciones.Visible = false;
                    panelSuscripciones.Visible = false;
                    MenuOpen = false;
                }
            }
        }
    }
}
