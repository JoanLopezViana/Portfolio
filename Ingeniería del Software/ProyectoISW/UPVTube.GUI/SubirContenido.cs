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
    public partial class SubirContenido : Form
    {
        private IUPVTubeService service;
        private UPVTubeApp upvtube;
        private Boolean isPublic = false;
        // All the subjects that can be selected
        private List<Subject> availableSubjects = new List<Subject>();
        // Selected subjects
        private List<Subject> selectedSubjects = new List<Subject>();
        
        public SubirContenido(IUPVTubeService service)
        {
            // TODO: Remove after testing
            /*for (int i = 0; i < 10; i++) {
                Subject subject = new Subject(i, "Subject " + i, "Subject " + i);
                service.AddSubject(subject);
            }*/


            InitializeComponent();
            // Service dependency injection
            this.service = service;

            // Populate subjects ComboBox
            availableSubjects = service.getAllSubjects().ToList();
            subjectsComboBox.DataSource = availableSubjects;
            subjectsComboBox.DisplayMember = "FullName";
            subjectsComboBox.Show();
        }
        public void AsignarMain(UPVTubeApp upvtube) => this.upvtube = upvtube;

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void flowLayoutPanel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void botonSubir_Click(object sender, EventArgs e)
        {
            // Check title is not empty
            if(tituloTBox.Text.Length < 1)
            {
                MessageBox.Show("Title is empty. Write a title and try again.", "Invalid title",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            // Check description is not empty
            if(descripcionTBox.Text.Length < 1)
            {
                MessageBox.Show("Description is empty. Write a description and try again.", "Invalid description",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            Content c = new Content("sampleUri", descripcionTBox.Text, isPublic, tituloTBox.Text, DateTime.Now, service.getUser());
            c.Subjects = selectedSubjects;

            try
            {
                service.SubirContenido(c);
                MessageBox.Show("Content has been uploaded successfully", "Success", 
                                MessageBoxButtons.OK, MessageBoxIcon.Information);
                clearUI();
            }
            catch(Exception ex)
            {
                MessageBox.Show("An error occured while uploading content. Error message: \n" + ex.Message, "Error",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
        }

        private void clearUI()
        {
            // Clear thext fields
            tituloTBox.Text = "";
            descripcionTBox.Text = "";
            SelectedSubjectsTextBox.Text = "";

            // Populate subjects ComboBox (list of subjects may have changed)
            availableSubjects = service.getAllSubjects().ToList();
            subjectsComboBox.DataSource = availableSubjects;
            subjectsComboBox.DisplayMember = "FullName";
            selectedSubjects = new List<Subject>();
            subjectsComboBox.Show();

        }

        private void toggleButton1_CheckedChanged(object sender, EventArgs e)
        {
            // Update content privacy value
            isPublic = PrivateButton.Checked;
        }

        private void AddSubjectButton_Click(object sender, EventArgs e)
        {
            // Check an item is selected
            if(subjectsComboBox.SelectedIndex < 0)
            {
                MessageBox.Show("Select a valid subject and try again", "Invalid subject",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Retrieve the selected subject
            Subject subject = availableSubjects[subjectsComboBox.SelectedIndex];

            // Check if the selected subject is already added
            if (selectedSubjects.Contains(subject)){
                MessageBox.Show("The selected subject is already added", "Invalid subject",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Add the selected subject to the selected subjects list
            selectedSubjects.Add(subject);
            //selectedSubjects.Sort();

            // Build the selected subjects string
            string selectedSubjectsString = "";
            for(int i = 0; i < selectedSubjects.Count; i++)
            {
                selectedSubjectsString += selectedSubjects[i].FullName + " ";
            }
            // Display the selected subjects string
            SelectedSubjectsTextBox.Text = selectedSubjectsString;
        }

        private void RemoveSubjectButton_Click(object sender, EventArgs e)
        {
            // Check an item is selected
            if (subjectsComboBox.SelectedIndex < 0)
            {
                MessageBox.Show("Select a valid subject and try again", "Invalid subject",
                                MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Retrieve the selected subject
            Subject subject = availableSubjects[subjectsComboBox.SelectedIndex];
            // Remove the selected subject from the selected subjects list
            selectedSubjects.Remove(subject);
            //selectedSubjects.Sort();

            // Build the selected subjects string
            string selectedSubjectsString = "";
            for (int i = 0; i < selectedSubjects.Count; i++)
            {
                selectedSubjectsString += selectedSubjects[i].FullName + " ";
            }
            // Display the selected subjects string
            SelectedSubjectsTextBox.Text = selectedSubjectsString;
        }
    }
}
