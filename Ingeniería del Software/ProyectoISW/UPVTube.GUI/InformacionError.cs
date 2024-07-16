using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UPVTube.GUI
{
    public partial class InformacionError : Form
    {
        public InformacionError(Exception e)
        {
            InitializeComponent();
            infoE.Text = e.Message;
        }
    }
}
