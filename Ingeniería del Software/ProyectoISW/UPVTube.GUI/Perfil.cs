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
    public partial class Perfil : Form
    {
        private IUPVTubeService service;
        private UPVTubeApp upvtube;
        Entities.Member member;//= service.getUser();
        private bool passw = false;

        public Member Member { get => member; set => member = value; }

        public Perfil(IUPVTubeService service)
        {
            InitializeComponent();
            this.service = service;

            textBox1.Text = service.getUser().FullName;
           textBox2.Text = service.getUser().Nick;
            Password.Text = service.getUser().Password;
            Correo.Text = service.getUser().Email;
        }
        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;


        private void Modif(object sender, EventArgs e) { 
   
            textBox1.Enabled = true;
              //  textBox2.Enabled = true;
                Password.Enabled = true;
                Correo.Enabled = true;
                button2.Visible = true;
                button2.Enabled = true; 
            button3.Visible = true;
            button3.Enabled = true;
        }

        private void Canc(object sender, EventArgs e)
        {
            textBox1.Enabled = false;
           textBox2.Enabled = false;
            Password.Enabled = false;
            Correo.Enabled = false;
            button2.Visible = false;
            button2.Enabled = false;
            button3.Visible = false;
            button2.Enabled = false;
        }

        private void acept(object sender, MouseEventArgs e)
        {
            textBox1.Enabled = false;
            textBox2.Enabled = false;
            Password.Enabled = false;
            Correo.Enabled = false;
            button2.Visible = false;
            button2.Enabled = false;
            button3.Visible = false;
            button2.Enabled = false;
            this.service.Modify(Correo.Text, textBox1.Text, DateTime.Now, textBox2.Text, Password.Text);
            textBox1.Text = service.getUser().FullName;
            textBox2.Text = service.getUser().Nick;
            Password.Text = service.getUser().Password;
            Correo.Text = service.getUser().Email;
        }

        private void pass(object sender, MouseEventArgs e)
        {
            Password.PasswordChar = (Password.PasswordChar == '\0') ? '*' : '\0';
        }
        private void TogglePassword(object sender, EventArgs e)
        {
            eyeClose.Visible = !eyeClose.Visible;
            eyeOpen.Visible = !eyeOpen.Visible;
            Password.PasswordChar = (Password.PasswordChar == '\0') ? '*' : '\0';
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
    }
}
