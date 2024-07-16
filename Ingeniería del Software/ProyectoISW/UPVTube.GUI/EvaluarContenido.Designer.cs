namespace UPVTube.GUI
{
    partial class EvaluarContenido
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.ImagePictureBox = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.AlumnoTextBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.DescripcionTextBox = new System.Windows.Forms.TextBox();
            this.flowLayoutPanel2 = new System.Windows.Forms.FlowLayoutPanel();
            this.label3 = new System.Windows.Forms.Label();
            this.TituloTextBox = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.FechaSubidaTextBox = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.AsignaturasTextBox = new System.Windows.Forms.TextBox();
            this.flowLayoutPanel3 = new System.Windows.Forms.FlowLayoutPanel();
            this.label6 = new System.Windows.Forms.Label();
            this.DeclineButton = new UPVTube.GUI.CustomControlls.ToggleButton();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.CommentTBox = new System.Windows.Forms.TextBox();
            this.ConfirmarButton = new System.Windows.Forms.Button();
            this.tableLayoutPanel1.SuspendLayout();
            this.flowLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ImagePictureBox)).BeginInit();
            this.flowLayoutPanel2.SuspendLayout();
            this.flowLayoutPanel3.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.tableLayoutPanel1.AutoSize = true;
            this.tableLayoutPanel1.ColumnCount = 2;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 28.19876F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 71.80124F));
            this.tableLayoutPanel1.Controls.Add(this.flowLayoutPanel1, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.flowLayoutPanel2, 1, 0);
            this.tableLayoutPanel1.Location = new System.Drawing.Point(12, 12);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(1610, 789);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.AutoSize = true;
            this.flowLayoutPanel1.Controls.Add(this.ImagePictureBox);
            this.flowLayoutPanel1.Controls.Add(this.label1);
            this.flowLayoutPanel1.Controls.Add(this.AlumnoTextBox);
            this.flowLayoutPanel1.Controls.Add(this.label2);
            this.flowLayoutPanel1.Controls.Add(this.DescripcionTextBox);
            this.flowLayoutPanel1.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.flowLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Padding = new System.Windows.Forms.Padding(20);
            this.flowLayoutPanel1.Size = new System.Drawing.Size(447, 767);
            this.flowLayoutPanel1.TabIndex = 0;
            // 
            // ImagePictureBox
            // 
            this.ImagePictureBox.ErrorImage = global::UPVTube.GUI.Properties.Resources.image_icon;
            this.ImagePictureBox.Image = global::UPVTube.GUI.Properties.Resources.image_icon;
            this.ImagePictureBox.InitialImage = global::UPVTube.GUI.Properties.Resources.image_icon;
            this.ImagePictureBox.Location = new System.Drawing.Point(23, 23);
            this.ImagePictureBox.Name = "ImagePictureBox";
            this.ImagePictureBox.Size = new System.Drawing.Size(240, 240);
            this.ImagePictureBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.ImagePictureBox.TabIndex = 0;
            this.ImagePictureBox.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(23, 326);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 60, 3, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(84, 25);
            this.label1.TabIndex = 1;
            this.label1.Text = "Alumno";
            // 
            // AlumnoTextBox
            // 
            this.AlumnoTextBox.Enabled = false;
            this.AlumnoTextBox.Location = new System.Drawing.Point(23, 361);
            this.AlumnoTextBox.Margin = new System.Windows.Forms.Padding(3, 10, 3, 3);
            this.AlumnoTextBox.Name = "AlumnoTextBox";
            this.AlumnoTextBox.ReadOnly = true;
            this.AlumnoTextBox.Size = new System.Drawing.Size(401, 31);
            this.AlumnoTextBox.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(23, 425);
            this.label2.Margin = new System.Windows.Forms.Padding(3, 30, 3, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(125, 25);
            this.label2.TabIndex = 2;
            this.label2.Text = "Descripción";
            // 
            // DescripcionTextBox
            // 
            this.DescripcionTextBox.Enabled = false;
            this.DescripcionTextBox.Location = new System.Drawing.Point(23, 460);
            this.DescripcionTextBox.Margin = new System.Windows.Forms.Padding(3, 10, 3, 3);
            this.DescripcionTextBox.Multiline = true;
            this.DescripcionTextBox.Name = "DescripcionTextBox";
            this.DescripcionTextBox.ReadOnly = true;
            this.DescripcionTextBox.Size = new System.Drawing.Size(401, 284);
            this.DescripcionTextBox.TabIndex = 4;
            // 
            // flowLayoutPanel2
            // 
            this.flowLayoutPanel2.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.flowLayoutPanel2.AutoSize = true;
            this.flowLayoutPanel2.Controls.Add(this.label3);
            this.flowLayoutPanel2.Controls.Add(this.TituloTextBox);
            this.flowLayoutPanel2.Controls.Add(this.label4);
            this.flowLayoutPanel2.Controls.Add(this.FechaSubidaTextBox);
            this.flowLayoutPanel2.Controls.Add(this.label5);
            this.flowLayoutPanel2.Controls.Add(this.AsignaturasTextBox);
            this.flowLayoutPanel2.Controls.Add(this.flowLayoutPanel3);
            this.flowLayoutPanel2.Controls.Add(this.label8);
            this.flowLayoutPanel2.Controls.Add(this.CommentTBox);
            this.flowLayoutPanel2.Controls.Add(this.ConfirmarButton);
            this.flowLayoutPanel2.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.flowLayoutPanel2.Location = new System.Drawing.Point(457, 3);
            this.flowLayoutPanel2.Name = "flowLayoutPanel2";
            this.flowLayoutPanel2.Padding = new System.Windows.Forms.Padding(20);
            this.flowLayoutPanel2.Size = new System.Drawing.Size(939, 783);
            this.flowLayoutPanel2.TabIndex = 1;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(23, 40);
            this.label3.Margin = new System.Windows.Forms.Padding(3, 20, 3, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(65, 25);
            this.label3.TabIndex = 4;
            this.label3.Text = "Título";
            // 
            // TituloTextBox
            // 
            this.TituloTextBox.Enabled = false;
            this.TituloTextBox.Location = new System.Drawing.Point(23, 75);
            this.TituloTextBox.Margin = new System.Windows.Forms.Padding(3, 10, 3, 3);
            this.TituloTextBox.Name = "TituloTextBox";
            this.TituloTextBox.ReadOnly = true;
            this.TituloTextBox.Size = new System.Drawing.Size(893, 31);
            this.TituloTextBox.TabIndex = 5;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(23, 129);
            this.label4.Margin = new System.Windows.Forms.Padding(3, 20, 3, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(172, 25);
            this.label4.TabIndex = 6;
            this.label4.Text = "Fecha de subida";
            // 
            // FechaSubidaTextBox
            // 
            this.FechaSubidaTextBox.Enabled = false;
            this.FechaSubidaTextBox.Location = new System.Drawing.Point(23, 164);
            this.FechaSubidaTextBox.Margin = new System.Windows.Forms.Padding(3, 10, 3, 3);
            this.FechaSubidaTextBox.Name = "FechaSubidaTextBox";
            this.FechaSubidaTextBox.ReadOnly = true;
            this.FechaSubidaTextBox.Size = new System.Drawing.Size(368, 31);
            this.FechaSubidaTextBox.TabIndex = 7;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(23, 218);
            this.label5.Margin = new System.Windows.Forms.Padding(3, 20, 3, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(126, 25);
            this.label5.TabIndex = 8;
            this.label5.Text = "Asignaturas";
            // 
            // AsignaturasTextBox
            // 
            this.AsignaturasTextBox.Enabled = false;
            this.AsignaturasTextBox.Location = new System.Drawing.Point(23, 253);
            this.AsignaturasTextBox.Margin = new System.Windows.Forms.Padding(3, 10, 3, 3);
            this.AsignaturasTextBox.Name = "AsignaturasTextBox";
            this.AsignaturasTextBox.ReadOnly = true;
            this.AsignaturasTextBox.Size = new System.Drawing.Size(893, 31);
            this.AsignaturasTextBox.TabIndex = 9;
            // 
            // flowLayoutPanel3
            // 
            this.flowLayoutPanel3.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.flowLayoutPanel3.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.flowLayoutPanel3.Controls.Add(this.label6);
            this.flowLayoutPanel3.Controls.Add(this.DeclineButton);
            this.flowLayoutPanel3.Controls.Add(this.label7);
            this.flowLayoutPanel3.Location = new System.Drawing.Point(23, 347);
            this.flowLayoutPanel3.Margin = new System.Windows.Forms.Padding(3, 60, 3, 2);
            this.flowLayoutPanel3.Name = "flowLayoutPanel3";
            this.flowLayoutPanel3.Size = new System.Drawing.Size(893, 64);
            this.flowLayoutPanel3.TabIndex = 10;
            this.flowLayoutPanel3.WrapContents = false;
            // 
            // label6
            // 
            this.label6.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(5, 17);
            this.label6.Margin = new System.Windows.Forms.Padding(5, 0, 0, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(86, 25);
            this.label6.TabIndex = 2;
            this.label6.Text = "Aceptar";
            this.label6.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.label6.UseMnemonic = false;
            // 
            // DeclineButton
            // 
            this.DeclineButton.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.DeclineButton.Location = new System.Drawing.Point(91, 10);
            this.DeclineButton.Margin = new System.Windows.Forms.Padding(0, 10, 0, 10);
            this.DeclineButton.MinimumSize = new System.Drawing.Size(45, 22);
            this.DeclineButton.Name = "DeclineButton";
            this.DeclineButton.OffBackColor = System.Drawing.Color.Green;
            this.DeclineButton.OffToggleColor = System.Drawing.Color.Gainsboro;
            this.DeclineButton.OnBackColor = System.Drawing.Color.Maroon;
            this.DeclineButton.OnToggleColor = System.Drawing.Color.WhiteSmoke;
            this.DeclineButton.Size = new System.Drawing.Size(100, 40);
            this.DeclineButton.TabIndex = 1;
            this.DeclineButton.UseVisualStyleBackColor = true;
            // 
            // label7
            // 
            this.label7.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(191, 17);
            this.label7.Margin = new System.Windows.Forms.Padding(0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(94, 25);
            this.label7.TabIndex = 3;
            this.label7.Text = "Denegar";
            this.label7.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.label7.UseMnemonic = false;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(23, 433);
            this.label8.Margin = new System.Windows.Forms.Padding(3, 20, 3, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(133, 25);
            this.label8.TabIndex = 11;
            this.label8.Text = "Comentarios";
            // 
            // CommentTBox
            // 
            this.CommentTBox.Location = new System.Drawing.Point(23, 468);
            this.CommentTBox.Margin = new System.Windows.Forms.Padding(3, 10, 3, 3);
            this.CommentTBox.Multiline = true;
            this.CommentTBox.Name = "CommentTBox";
            this.CommentTBox.Size = new System.Drawing.Size(893, 192);
            this.CommentTBox.TabIndex = 12;
            // 
            // ConfirmarButton
            // 
            this.ConfirmarButton.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.ConfirmarButton.Location = new System.Drawing.Point(20, 683);
            this.ConfirmarButton.Margin = new System.Windows.Forms.Padding(0, 20, 3, 3);
            this.ConfirmarButton.Name = "ConfirmarButton";
            this.ConfirmarButton.Size = new System.Drawing.Size(172, 60);
            this.ConfirmarButton.TabIndex = 13;
            this.ConfirmarButton.Text = "Confirmar";
            this.ConfirmarButton.UseVisualStyleBackColor = true;
            this.ConfirmarButton.Click += new System.EventHandler(this.ConfirmarButton_Click);
            // 
            // EvaluarContenido
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.WhiteSmoke;
            this.ClientSize = new System.Drawing.Size(1685, 825);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "EvaluarContenido";
            this.Text = "EvaluarContenido";
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.flowLayoutPanel1.ResumeLayout(false);
            this.flowLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ImagePictureBox)).EndInit();
            this.flowLayoutPanel2.ResumeLayout(false);
            this.flowLayoutPanel2.PerformLayout();
            this.flowLayoutPanel3.ResumeLayout(false);
            this.flowLayoutPanel3.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.PictureBox ImagePictureBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox AlumnoTextBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox DescripcionTextBox;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox TituloTextBox;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox FechaSubidaTextBox;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox AsignaturasTextBox;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel3;
        private System.Windows.Forms.Label label6;
        private CustomControlls.ToggleButton DeclineButton;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox CommentTBox;
        private System.Windows.Forms.Button ConfirmarButton;
    }
}