namespace UPVTube.GUI
{
    partial class InformacionError
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
            this.infoE = new System.Windows.Forms.Label();
            this.tituloE = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // infoE
            // 
            this.infoE.Location = new System.Drawing.Point(13, 93);
            this.infoE.Name = "infoE";
            this.infoE.Size = new System.Drawing.Size(407, 130);
            this.infoE.TabIndex = 3;
            // 
            // tituloE
            // 
            this.tituloE.AutoSize = true;
            this.tituloE.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tituloE.Location = new System.Drawing.Point(26, 9);
            this.tituloE.Name = "tituloE";
            this.tituloE.Size = new System.Drawing.Size(380, 46);
            this.tituloE.TabIndex = 2;
            this.tituloE.Text = "Error en el Sistema";
            // 
            // InformacionError
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(432, 232);
            this.Controls.Add(this.infoE);
            this.Controls.Add(this.tituloE);
            this.Name = "InformacionError";
            this.Text = "InformacionError";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label infoE;
        private System.Windows.Forms.Label tituloE;
    }
}