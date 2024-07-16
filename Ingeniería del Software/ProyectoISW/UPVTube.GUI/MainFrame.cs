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
using System.Runtime.InteropServices;
using UPVTube.Entities;

namespace UPVTube.GUI
{
    public partial class MainFrame : Form
    {
        private IUPVTubeService service;
        private Form activeForm = null;
        private bool loged = false;

        public MainFrame(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;
            
            //service.RemoveAllData();
            if (service.DBIsEmpty()) service.DBInitialization(); //iniciar base de datos si está vacia
            SetStyle(ControlStyles.OptimizedDoubleBuffer, true);
            //this.DoubleBuffered = true;
        }


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
            Form.Location = new Point(0, 0);
            activeForm = Form;
        }

        private void MainFrame_Load(object sender, EventArgs e)
        {
            logOut();
            NavegarLogin();
        }
        //=========================================================================
        //CAMBIAR LOGIN, REGISTRARSE
        public void NavegarLogin()
        {
            Login login = new Login(service);
            login.setMainFrame(this);
            Navegar(login);
        }

        public void NavegarRegistrarse()
        {
            Registrarse registrarse = new Registrarse(service);
            registrarse.setMainFrame(this);
            Navegar(registrarse);
        }
        //=========================================================================
        //MENÚ
        //private void MenuOpenClose(object sender, EventArgs e)
        //{
        //    if (!loged) return;
        //    UPVTubeApp app = (UPVTubeApp)activeForm;
        //    app.MenuToggle(null,null);
        //}
        //=========================================================================
        //ENTRAR CON USUARIO Y SALIR 
        public void logOut()
        {
            Login app = new Login(service);
            app.setMainFrame(this);
            Navegar(app);
            loged = false;
        }
        public void logIn()
        {
            UPVTubeApp app = new UPVTubeApp(service);
            app.setMainFrame(this);
            Navegar(app);
            loged = true;
        }
       
    }
}
