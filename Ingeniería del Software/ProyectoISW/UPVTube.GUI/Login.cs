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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace UPVTube.GUI
{
    public partial class Login : Form
    {
        private IUPVTubeService service;
        private MainFrame lr;

        public Login(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;
            enableActivar(null,null);
        }
        public void setMainFrame(MainFrame lr) => this.lr = lr;

        private void Login_Load(object sender, EventArgs e)
        {

        }

        private void Registrarse(object sender, EventArgs e)
        {
            lr.NavegarRegistrarse();
        }

        private void TogglePassword(object sender, EventArgs e)
        {
            eyeClose.Visible = !eyeClose.Visible;
            eyeOpen.Visible = !eyeOpen.Visible;
            Password.PasswordChar = (Password.PasswordChar == '\0') ? '*' : '\0';
        }

        private void Aceptar(object sender, EventArgs e)
        {
            try
            {
                service.Login(Nickname.Text, Password.Text);
                lr.logIn();
            }catch (ServiceException ex)
            {
                ErrorNick.Text = ""; ErrorPassword.Text = "";
                if (ex.Message == "El usuario NO existe")
                {
                    ErrorNick.Text = ex.Message;
                }
                if (ex.Message == "Contraseña incorrecta")
                {
                    ErrorPassword.Text = ex.Message;
                }
            }
        }
        private void enableActivar(object sender, EventArgs e)
        {
            AceptarButton.Enabled = (Nickname.Text != "" && Password.Text != "");
        }

        private void HoverEnter(object sender, EventArgs e)
        {
            eyeClose.BackColor = Color.Gainsboro;
            eyeOpen.BackColor = Color.Gainsboro;
        }

        private void HoverLeave(object sender, EventArgs e)
        {
            eyeClose.BackColor = Color.Transparent;
            eyeOpen.BackColor = Color.Transparent;
        }

        private void panel5_Paint(object sender, PaintEventArgs e)
        {

        }

        private void acept(object sender, KeyPressEventArgs e)
        {if(e.KeyChar==13)
            try
            {
                service.Login(Nickname.Text, Password.Text);
                lr.logIn();
            }
            catch (ServiceException ex)
            {
                ErrorNick.Text = ""; ErrorPassword.Text = "";
                if (ex.Message == "El usuario NO existe")
                {
                    ErrorNick.Text = ex.Message;
                }
                if (ex.Message == "Contraseña incorrecta")
                {
                    ErrorPassword.Text = ex.Message;
                }
            }
        }

        private void pass(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                // Cambia el foco al siguiente TextBox
                Password.Focus();
            }
        }
    }
}
