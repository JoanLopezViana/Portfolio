namespace UPVTube.GUI
{
    partial class Suscripciones
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
            this.Sus = new System.Windows.Forms.ListView();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.SuspendLayout();
            // 
            // Sus
            // 
            this.Sus.Activation = System.Windows.Forms.ItemActivation.OneClick;
            this.Sus.HideSelection = false;
            this.Sus.HoverSelection = true;
            this.Sus.Location = new System.Drawing.Point(0, 0);
            this.Sus.Name = "Sus";
            this.Sus.Size = new System.Drawing.Size(276, 336);
            this.Sus.TabIndex = 0;
            this.Sus.UseCompatibleStateImageBehavior = false;
            this.Sus.View = System.Windows.Forms.View.Details;
            // 
            // Suscripciones
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(276, 336);
            this.Controls.Add(this.Sus);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Suscripciones";
            this.Text = "Suscripciones";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView Sus;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
    }
}