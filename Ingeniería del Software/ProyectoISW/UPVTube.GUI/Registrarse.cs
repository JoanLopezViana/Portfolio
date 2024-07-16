using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UPVTube.Entities;
using UPVTube.Services;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace UPVTube.GUI
{
    public partial class Registrarse : Form
    {
        private IUPVTubeService service;
        MainFrame lr;

        public Registrarse(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;
            enableActivar(null, null);

        }
        public void setMainFrame(MainFrame lr) => this.lr = lr;

        private void Aceptar(object sender, EventArgs e)
        {
            try
            {
                if (Nickname.Text.Contains(" "))
                    throw new ServiceException("El Nickname NO puede contener espacios");
                if (Password.Text.Contains(" "))
                    throw new ServiceException("La Contraseña NO puede contener espacios");
                if (Correo.Text.Contains(" "))
                    throw new ServiceException("El Correo NO puede contener espacios");
                if (FullName.Text.Any(char.IsDigit))
                    throw new ServiceException("El Nombre NO puede contener dígitos");
                if (FullName.Text.Any(n => !char.IsLetter(n) && n != ' '))
                    throw new ServiceException("El Nombre SOLO puede tener carácteres alfabéticos");
                Member m = new Member(Correo.Text, FullName.Text,
                                   DateTime.Now, Nickname.Text, Password.Text);
                service.Registrarse(m);
                service.Login(m.Nick,m.Password);
                lr.logIn();
            }
            catch (ServiceException ex)
            {
                ErrorNick.Text = ""; ErrorPassword.Text = "";
                ErrorName.Text = ""; ErrorCorreo.Text = "";
                if (ex.Message == "Nickname ya en uso"
                 || ex.Message == "El Nickname NO puede contener espacios")
                {
                    ErrorNick.Text = ex.Message + ", elige otro Nickname";
                }
                if (ex.Message == "Email en uso")
                {
                    ErrorCorreo.Text = ex.Message + ", elige otro correo";
                }
                if (ex.Message == "El Correo NO puede contener espacios")
                {
                    ErrorCorreo.Text = ex.Message;
                }
                if (ex.Message == "La Contraseña NO puede contener espacios")
                {
                    ErrorPassword.Text = ex.Message + ", elige otra contraseña";
                }
                if (ex.Message == "El Nombre NO puede contener dígitos"
                 || ex.Message == "El Nombre SOLO puede tener carácteres alfabéticos")
                {
                    ErrorName.Text = ex.Message;
                }
            }
        }

        private void TogglePassword(object sender, EventArgs e)
        {
            eyeClose.Visible = !eyeClose.Visible;
            eyeOpen.Visible = !eyeOpen.Visible;
            Password.PasswordChar = (Password.PasswordChar == '\0') ? '*' : '\0';
        }

        private void Login(object sender, EventArgs e)
        {
            lr.NavegarLogin();
        }

        private void enableActivar(object sender, EventArgs e)
        {
            AceptarButton.Enabled = (FullName.Text != "" && Correo.Text != "" && Nickname.Text != "" && Password.Text != "");
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

        private void Pass(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                // Cambia el foco al siguiente TextBox
                Correo.Focus();
            }
        }

        private void pass(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                // Cambia el foco al siguiente TextBox
                Nickname.Focus();
            }
        }

        private void passn(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                // Cambia el foco al siguiente TextBox
                Password.Focus();
            }
        }

        private void Accept(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter) try
                {
                    if (Nickname.Text.Contains(" "))
                        throw new ServiceException("El Nickname NO puede contener espacios");
                    if (Password.Text.Contains(" "))
                        throw new ServiceException("La Contraseña NO puede contener espacios");
                    if (Correo.Text.Contains(" "))
                        throw new ServiceException("El Correo NO puede contener espacios");
                    if (FullName.Text.Any(char.IsDigit))
                        throw new ServiceException("El Nombre NO puede contener dígitos");
                    if (FullName.Text.Any(n => !char.IsLetter(n) && n != ' '))
                        throw new ServiceException("El Nombre SOLO puede tener carácteres alfabéticos");
                    Member m = new Member(Correo.Text, FullName.Text,
                                       DateTime.Now, Nickname.Text, Password.Text);
                    service.Registrarse(m);
                    service.Login(m.Nick, m.Password);
                    lr.logIn();
                }
                catch (ServiceException ex)
                {
                    ErrorNick.Text = ""; ErrorPassword.Text = "";
                    ErrorName.Text = ""; ErrorCorreo.Text = "";
                    if (ex.Message == "Nickname ya en uso"
                     || ex.Message == "El Nickname NO puede contener espacios")
                    {
                        ErrorNick.Text = ex.Message + ", elige otro Nickname";
                    }
                    if (ex.Message == "Email en uso")
                    {
                        ErrorCorreo.Text = ex.Message + ", elige otro correo";
                    }
                    if (ex.Message == "El Correo NO puede contener espacios")
                    {
                        ErrorCorreo.Text = ex.Message;
                    }
                    if (ex.Message == "La Contraseña NO puede contener espacios")
                    {
                        ErrorPassword.Text = ex.Message + ", elige otra contraseña";
                    }
                    if (ex.Message == "El Nombre NO puede contener dígitos"
                     || ex.Message == "El Nombre SOLO puede tener carácteres alfabéticos")
                    {
                        ErrorName.Text = ex.Message;
                    }
                };
        }
    }
}
