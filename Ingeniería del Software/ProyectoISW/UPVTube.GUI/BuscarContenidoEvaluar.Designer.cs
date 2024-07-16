namespace UPVTube.GUI
{
    partial class BuscarContenidoEvaluar
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
            System.Windows.Forms.ListViewItem listViewItem1 = new System.Windows.Forms.ListViewItem("a");
            System.Windows.Forms.ListViewItem listViewItem2 = new System.Windows.Forms.ListViewItem("b");
            System.Windows.Forms.ListViewItem listViewItem3 = new System.Windows.Forms.ListViewItem("c");
            this.advancedSearch = new System.Windows.Forms.Panel();
            this.endDateSearch = new System.Windows.Forms.DateTimePicker();
            this.iniDateSearch = new System.Windows.Forms.DateTimePicker();
            this.subjectSearch = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.makerSearch = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.button3 = new System.Windows.Forms.Button();
            this.listaVideos = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Buscar = new System.Windows.Forms.Button();
            this.paternSearch = new System.Windows.Forms.TextBox();
            this.advancedSearch.SuspendLayout();
            this.SuspendLayout();
            // 
            // advancedSearch
            // 
            this.advancedSearch.Controls.Add(this.endDateSearch);
            this.advancedSearch.Controls.Add(this.iniDateSearch);
            this.advancedSearch.Controls.Add(this.subjectSearch);
            this.advancedSearch.Controls.Add(this.label4);
            this.advancedSearch.Controls.Add(this.label3);
            this.advancedSearch.Controls.Add(this.makerSearch);
            this.advancedSearch.Controls.Add(this.label2);
            this.advancedSearch.Controls.Add(this.label1);
            this.advancedSearch.Location = new System.Drawing.Point(12, 50);
            this.advancedSearch.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.advancedSearch.Name = "advancedSearch";
            this.advancedSearch.Size = new System.Drawing.Size(957, 72);
            this.advancedSearch.TabIndex = 10;
            this.advancedSearch.Visible = false;
            // 
            // endDateSearch
            // 
            this.endDateSearch.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.endDateSearch.Location = new System.Drawing.Point(69, 38);
            this.endDateSearch.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.endDateSearch.Name = "endDateSearch";
            this.endDateSearch.Size = new System.Drawing.Size(200, 26);
            this.endDateSearch.TabIndex = 16;
            this.endDateSearch.Value = new System.DateTime(2024, 1, 4, 0, 0, 0, 0);
            this.endDateSearch.ValueChanged += new System.EventHandler(this.endDateSearch_ValueChanged);
            // 
            // iniDateSearch
            // 
            this.iniDateSearch.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.iniDateSearch.Location = new System.Drawing.Point(69, 2);
            this.iniDateSearch.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.iniDateSearch.Name = "iniDateSearch";
            this.iniDateSearch.Size = new System.Drawing.Size(200, 26);
            this.iniDateSearch.TabIndex = 6;
            this.iniDateSearch.Value = new System.DateTime(2023, 1, 4, 11, 44, 0, 0);
            // 
            // subjectSearch
            // 
            this.subjectSearch.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.subjectSearch.FormattingEnabled = true;
            this.subjectSearch.Location = new System.Drawing.Point(692, 4);
            this.subjectSearch.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.subjectSearch.Name = "subjectSearch";
            this.subjectSearch.Size = new System.Drawing.Size(262, 28);
            this.subjectSearch.TabIndex = 15;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(596, 6);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(90, 20);
            this.label4.TabIndex = 14;
            this.label4.Text = "Asignatura:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(273, 6);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(70, 20);
            this.label3.TabIndex = 12;
            this.label3.Text = "Creador:";
            // 
            // makerSearch
            // 
            this.makerSearch.Location = new System.Drawing.Point(349, 4);
            this.makerSearch.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.makerSearch.Name = "makerSearch";
            this.makerSearch.Size = new System.Drawing.Size(241, 26);
            this.makerSearch.TabIndex = 11;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 42);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(56, 20);
            this.label2.TabIndex = 10;
            this.label2.Text = "Hasta:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 6);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(60, 20);
            this.label1.TabIndex = 9;
            this.label1.Text = "Desde:";
            // 
            // button3
            // 
            this.button3.BackgroundImage = global::UPVTube.GUI.Properties.Resources.filter_line_icon;
            this.button3.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.button3.Location = new System.Drawing.Point(939, 13);
            this.button3.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(30, 26);
            this.button3.TabIndex = 9;
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // listaVideos
            // 
            this.listaVideos.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3});
            this.listaVideos.HideSelection = false;
            this.listaVideos.Items.AddRange(new System.Windows.Forms.ListViewItem[] {
            listViewItem1,
            listViewItem2,
            listViewItem3});
            this.listaVideos.Location = new System.Drawing.Point(12, 54);
            this.listaVideos.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.listaVideos.Name = "listaVideos";
            this.listaVideos.Size = new System.Drawing.Size(957, 449);
            this.listaVideos.TabIndex = 7;
            this.listaVideos.UseCompatibleStateImageBehavior = false;
            this.listaVideos.View = System.Windows.Forms.View.Details;
            this.listaVideos.SelectedIndexChanged += new System.EventHandler(this.listaVideos_SelectedIndexChanged);
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Miniatura";
            this.columnHeader1.Width = 120;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "titulo";
            this.columnHeader2.Width = 360;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "usuario";
            this.columnHeader3.Width = 120;
            // 
            // Buscar
            // 
            this.Buscar.BackgroundImage = global::UPVTube.GUI.Properties.Resources.search_icon;
            this.Buscar.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.Buscar.Location = new System.Drawing.Point(10, 14);
            this.Buscar.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.Buscar.Name = "Buscar";
            this.Buscar.Size = new System.Drawing.Size(30, 26);
            this.Buscar.TabIndex = 8;
            this.Buscar.UseVisualStyleBackColor = true;
            this.Buscar.Click += new System.EventHandler(this.Buscar_Click);
            // 
            // paternSearch
            // 
            this.paternSearch.Location = new System.Drawing.Point(46, 14);
            this.paternSearch.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.paternSearch.Name = "paternSearch";
            this.paternSearch.Size = new System.Drawing.Size(887, 26);
            this.paternSearch.TabIndex = 6;
            // 
            // BuscarContenidoEvaluar
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(981, 514);
            this.Controls.Add(this.advancedSearch);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.listaVideos);
            this.Controls.Add(this.Buscar);
            this.Controls.Add(this.paternSearch);
            this.Name = "BuscarContenidoEvaluar";
            this.Text = "BuscarContenidoEvaluar";
            this.advancedSearch.ResumeLayout(false);
            this.advancedSearch.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel advancedSearch;
        private System.Windows.Forms.DateTimePicker endDateSearch;
        private System.Windows.Forms.DateTimePicker iniDateSearch;
        private System.Windows.Forms.ComboBox subjectSearch;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox makerSearch;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.ListView listaVideos;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.Button Buscar;
        private System.Windows.Forms.TextBox paternSearch;
    }
}