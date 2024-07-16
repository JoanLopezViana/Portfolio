namespace UPVTube.GUI
{
    partial class VisualizarContenido
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
            this.button1 = new System.Windows.Forms.Button();
            this.titleV = new System.Windows.Forms.Label();
            this.descriptV = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.addComment = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.newComent = new System.Windows.Forms.TextBox();
            this.listaVideos = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.suscribeButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.button1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.button1.Location = new System.Drawing.Point(13, 13);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(656, 360);
            this.button1.TabIndex = 0;
            this.button1.UseVisualStyleBackColor = false;
            // 
            // titleV
            // 
            this.titleV.AutoSize = true;
            this.titleV.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.titleV.Location = new System.Drawing.Point(12, 376);
            this.titleV.Name = "titleV";
            this.titleV.Size = new System.Drawing.Size(85, 32);
            this.titleV.TabIndex = 1;
            this.titleV.Text = "Titulo";
            // 
            // descriptV
            // 
            this.descriptV.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.descriptV.Location = new System.Drawing.Point(12, 417);
            this.descriptV.Name = "descriptV";
            this.descriptV.Size = new System.Drawing.Size(657, 132);
            this.descriptV.TabIndex = 2;
            this.descriptV.Text = "Descripcion";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(675, 68);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(129, 25);
            this.label1.TabIndex = 4;
            this.label1.Text = "Comentarios:";
            // 
            // addComment
            // 
            this.addComment.BackgroundImage = global::UPVTube.GUI.Properties.Resources.plus_icon;
            this.addComment.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.addComment.Location = new System.Drawing.Point(947, 13);
            this.addComment.Name = "addComment";
            this.addComment.Size = new System.Drawing.Size(23, 23);
            this.addComment.TabIndex = 5;
            this.addComment.UseVisualStyleBackColor = true;
            this.addComment.Click += new System.EventHandler(this.addComment_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(675, 13);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(104, 25);
            this.label2.TabIndex = 7;
            this.label2.Text = "Comentar:";
            // 
            // newComent
            // 
            this.newComent.Location = new System.Drawing.Point(680, 39);
            this.newComent.Name = "newComent";
            this.newComent.Size = new System.Drawing.Size(290, 26);
            this.newComent.TabIndex = 8;
            // 
            // listaVideos
            // 
            this.listaVideos.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2});
            this.listaVideos.HideSelection = false;
            this.listaVideos.Location = new System.Drawing.Point(680, 95);
            this.listaVideos.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.listaVideos.Name = "listaVideos";
            this.listaVideos.Size = new System.Drawing.Size(290, 454);
            this.listaVideos.TabIndex = 9;
            this.listaVideos.UseCompatibleStateImageBehavior = false;
            this.listaVideos.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Usuario";
            this.columnHeader1.Width = 117;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Comentario";
            this.columnHeader2.Width = 180;
            // 
            // suscribeButton
            // 
            this.suscribeButton.Location = new System.Drawing.Point(547, 376);
            this.suscribeButton.Name = "suscribeButton";
            this.suscribeButton.Size = new System.Drawing.Size(122, 31);
            this.suscribeButton.TabIndex = 10;
            this.suscribeButton.Text = "Suscribirse";
            this.suscribeButton.UseVisualStyleBackColor = true;
            this.suscribeButton.Click += new System.EventHandler(this.suscribeButton_Click);
            // 
            // VisualizarContenido
            // 
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Inherit;
            this.ClientSize = new System.Drawing.Size(982, 559);
            this.Controls.Add(this.suscribeButton);
            this.Controls.Add(this.listaVideos);
            this.Controls.Add(this.newComent);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.addComment);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.descriptV);
            this.Controls.Add(this.titleV);
            this.Controls.Add(this.button1);
            this.Name = "VisualizarContenido";
            this.Text = "VisualizarContenido";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label titleV;
        private System.Windows.Forms.Label descriptV;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button addComment;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox newComent;
        private System.Windows.Forms.ListView listaVideos;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.Button suscribeButton;
    }
}