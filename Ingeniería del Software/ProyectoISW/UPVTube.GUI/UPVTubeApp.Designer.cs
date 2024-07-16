namespace UPVTube.GUI
{
    partial class UPVTubeApp
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.panel1 = new System.Windows.Forms.Panel();
            this.menuPanel = new System.Windows.Forms.Panel();
            this.panelSuscripciones = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.Suscripciones = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.LogOutButton = new System.Windows.Forms.Button();
            this.HistorialButton = new System.Windows.Forms.Button();
            this.PerfilButton = new System.Windows.Forms.Button();
            this.EvaluarContenidoButton = new System.Windows.Forms.Button();
            this.SubirContenidoButton = new System.Windows.Forms.Button();
            this.HomeButton = new System.Windows.Forms.Button();
            this.MenuButton = new System.Windows.Forms.Button();
            this.panel3 = new System.Windows.Forms.Panel();
            this.MenuTransition = new System.Windows.Forms.Timer(this.components);
            this.panel1.SuspendLayout();
            this.menuPanel.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.WhiteSmoke;
            this.panel1.Controls.Add(this.menuPanel);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Margin = new System.Windows.Forms.Padding(0);
            this.panel1.MaximumSize = new System.Drawing.Size(1366, 768);
            this.panel1.MinimumSize = new System.Drawing.Size(1366, 768);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1366, 768);
            this.panel1.TabIndex = 1;
            // 
            // menuPanel
            // 
            this.menuPanel.AutoScroll = true;
            this.menuPanel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(163)))), ((int)(((byte)(209)))));
            this.menuPanel.Controls.Add(this.panelSuscripciones);
            this.menuPanel.Controls.Add(this.panel2);
            this.menuPanel.Controls.Add(this.groupBox2);
            this.menuPanel.Controls.Add(this.LogOutButton);
            this.menuPanel.Controls.Add(this.HistorialButton);
            this.menuPanel.Controls.Add(this.PerfilButton);
            this.menuPanel.Controls.Add(this.EvaluarContenidoButton);
            this.menuPanel.Controls.Add(this.SubirContenidoButton);
            this.menuPanel.Controls.Add(this.HomeButton);
            this.menuPanel.Controls.Add(this.MenuButton);
            this.menuPanel.Controls.Add(this.panel3);
            this.menuPanel.Dock = System.Windows.Forms.DockStyle.Left;
            this.menuPanel.Location = new System.Drawing.Point(0, 0);
            this.menuPanel.Margin = new System.Windows.Forms.Padding(0);
            this.menuPanel.Name = "menuPanel";
            this.menuPanel.Size = new System.Drawing.Size(280, 768);
            this.menuPanel.TabIndex = 15;
            // 
            // panelSuscripciones
            // 
            this.panelSuscripciones.AutoScroll = true;
            this.panelSuscripciones.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(163)))), ((int)(((byte)(209)))));
            this.panelSuscripciones.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panelSuscripciones.Location = new System.Drawing.Point(0, 433);
            this.panelSuscripciones.MaximumSize = new System.Drawing.Size(276, 391);
            this.panelSuscripciones.Name = "panelSuscripciones";
            this.panelSuscripciones.Size = new System.Drawing.Size(276, 335);
            this.panelSuscripciones.TabIndex = 10;
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(163)))), ((int)(((byte)(209)))));
            this.panel2.Controls.Add(this.Suscripciones);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel2.Location = new System.Drawing.Point(0, 375);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(276, 58);
            this.panel2.TabIndex = 13;
            // 
            // Suscripciones
            // 
            this.Suscripciones.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.Suscripciones.BackColor = System.Drawing.Color.Transparent;
            this.Suscripciones.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.Suscripciones.Font = new System.Drawing.Font("Calibri", 14F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Suscripciones.ForeColor = System.Drawing.Color.White;
            this.Suscripciones.Location = new System.Drawing.Point(14, 13);
            this.Suscripciones.Name = "Suscripciones";
            this.Suscripciones.Size = new System.Drawing.Size(149, 29);
            this.Suscripciones.TabIndex = 11;
            this.Suscripciones.Text = "Suscripciones";
            this.Suscripciones.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            // 
            // groupBox2
            // 
            this.groupBox2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(13)))), ((int)(((byte)(131)))), ((int)(((byte)(158)))));
            this.groupBox2.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox2.Location = new System.Drawing.Point(0, 371);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(0);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(0);
            this.groupBox2.Size = new System.Drawing.Size(276, 4);
            this.groupBox2.TabIndex = 12;
            this.groupBox2.TabStop = false;
            // 
            // LogOutButton
            // 
            this.LogOutButton.BackColor = System.Drawing.Color.Transparent;
            this.LogOutButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.LogOutButton.FlatAppearance.BorderSize = 0;
            this.LogOutButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(93)))), ((int)(((byte)(223)))), ((int)(((byte)(252)))));
            this.LogOutButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.LogOutButton.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LogOutButton.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.LogOutButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_cierre_de_sesión_redondeado_hacia_la_izquierda_32_white;
            this.LogOutButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.LogOutButton.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.LogOutButton.Location = new System.Drawing.Point(0, 316);
            this.LogOutButton.Margin = new System.Windows.Forms.Padding(0);
            this.LogOutButton.Name = "LogOutButton";
            this.LogOutButton.Size = new System.Drawing.Size(276, 55);
            this.LogOutButton.TabIndex = 6;
            this.LogOutButton.Text = "         Salir";
            this.LogOutButton.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.LogOutButton.UseVisualStyleBackColor = false;
            this.LogOutButton.Click += new System.EventHandler(this.NavegarLogOut);
            // 
            // HistorialButton
            // 
            this.HistorialButton.BackColor = System.Drawing.Color.Transparent;
            this.HistorialButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.HistorialButton.FlatAppearance.BorderSize = 0;
            this.HistorialButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(93)))), ((int)(((byte)(223)))), ((int)(((byte)(252)))));
            this.HistorialButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.HistorialButton.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.HistorialButton.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.HistorialButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_pasado_32;
            this.HistorialButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.HistorialButton.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.HistorialButton.Location = new System.Drawing.Point(0, 261);
            this.HistorialButton.Margin = new System.Windows.Forms.Padding(0);
            this.HistorialButton.Name = "HistorialButton";
            this.HistorialButton.Size = new System.Drawing.Size(276, 55);
            this.HistorialButton.TabIndex = 5;
            this.HistorialButton.Text = "         Historial";
            this.HistorialButton.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.HistorialButton.UseVisualStyleBackColor = false;
            this.HistorialButton.Click += new System.EventHandler(this.NavegaHistorial);
            // 
            // PerfilButton
            // 
            this.PerfilButton.BackColor = System.Drawing.Color.Transparent;
            this.PerfilButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.PerfilButton.FlatAppearance.BorderSize = 0;
            this.PerfilButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(93)))), ((int)(((byte)(223)))), ((int)(((byte)(252)))));
            this.PerfilButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.PerfilButton.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.PerfilButton.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.PerfilButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_invitado_masculino_32_white;
            this.PerfilButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.PerfilButton.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.PerfilButton.Location = new System.Drawing.Point(0, 206);
            this.PerfilButton.Margin = new System.Windows.Forms.Padding(0);
            this.PerfilButton.Name = "PerfilButton";
            this.PerfilButton.Size = new System.Drawing.Size(276, 55);
            this.PerfilButton.TabIndex = 2;
            this.PerfilButton.Text = "         Perfil";
            this.PerfilButton.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.PerfilButton.UseVisualStyleBackColor = false;
            this.PerfilButton.Click += new System.EventHandler(this.NavegarPerfil);
            // 
            // EvaluarContenidoButton
            // 
            this.EvaluarContenidoButton.BackColor = System.Drawing.Color.Transparent;
            this.EvaluarContenidoButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.EvaluarContenidoButton.FlatAppearance.BorderSize = 0;
            this.EvaluarContenidoButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(93)))), ((int)(((byte)(223)))), ((int)(((byte)(252)))));
            this.EvaluarContenidoButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.EvaluarContenidoButton.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.EvaluarContenidoButton.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.EvaluarContenidoButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_firma_digital_32;
            this.EvaluarContenidoButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.EvaluarContenidoButton.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.EvaluarContenidoButton.Location = new System.Drawing.Point(0, 151);
            this.EvaluarContenidoButton.Margin = new System.Windows.Forms.Padding(0);
            this.EvaluarContenidoButton.Name = "EvaluarContenidoButton";
            this.EvaluarContenidoButton.Size = new System.Drawing.Size(276, 55);
            this.EvaluarContenidoButton.TabIndex = 4;
            this.EvaluarContenidoButton.Text = "         Evaluar contenido";
            this.EvaluarContenidoButton.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.EvaluarContenidoButton.UseVisualStyleBackColor = false;
            this.EvaluarContenidoButton.Click += new System.EventHandler(this.NavergarBuscarContenidoEvaluar);
            // 
            // SubirContenidoButton
            // 
            this.SubirContenidoButton.BackColor = System.Drawing.Color.Transparent;
            this.SubirContenidoButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.SubirContenidoButton.FlatAppearance.BorderSize = 0;
            this.SubirContenidoButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(93)))), ((int)(((byte)(223)))), ((int)(((byte)(252)))));
            this.SubirContenidoButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.SubirContenidoButton.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.SubirContenidoButton.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.SubirContenidoButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_subir_32_white;
            this.SubirContenidoButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.SubirContenidoButton.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.SubirContenidoButton.Location = new System.Drawing.Point(0, 96);
            this.SubirContenidoButton.Margin = new System.Windows.Forms.Padding(0);
            this.SubirContenidoButton.Name = "SubirContenidoButton";
            this.SubirContenidoButton.Size = new System.Drawing.Size(276, 55);
            this.SubirContenidoButton.TabIndex = 0;
            this.SubirContenidoButton.Text = "         Subir contenido";
            this.SubirContenidoButton.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.SubirContenidoButton.UseVisualStyleBackColor = false;
            this.SubirContenidoButton.Click += new System.EventHandler(this.NavergarSubirContenido);
            // 
            // HomeButton
            // 
            this.HomeButton.BackColor = System.Drawing.Color.Transparent;
            this.HomeButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.HomeButton.FlatAppearance.BorderSize = 0;
            this.HomeButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(93)))), ((int)(((byte)(223)))), ((int)(((byte)(252)))));
            this.HomeButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.HomeButton.Font = new System.Drawing.Font("Calibri", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.HomeButton.ForeColor = System.Drawing.Color.WhiteSmoke;
            this.HomeButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_casa_32_white;
            this.HomeButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.HomeButton.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.HomeButton.Location = new System.Drawing.Point(0, 41);
            this.HomeButton.Margin = new System.Windows.Forms.Padding(0);
            this.HomeButton.Name = "HomeButton";
            this.HomeButton.Size = new System.Drawing.Size(276, 55);
            this.HomeButton.TabIndex = 1;
            this.HomeButton.Text = "         Home";
            this.HomeButton.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.HomeButton.UseVisualStyleBackColor = false;
            this.HomeButton.Click += new System.EventHandler(this.NavegarHome);
            // 
            // MenuButton
            // 
            this.MenuButton.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(249)))), ((int)(((byte)(165)))), ((int)(((byte)(69)))));
            this.MenuButton.Dock = System.Windows.Forms.DockStyle.Top;
            this.MenuButton.FlatAppearance.BorderSize = 0;
            this.MenuButton.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(147)))), ((int)(((byte)(53)))));
            this.MenuButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.MenuButton.Image = global::UPVTube.GUI.Properties.Resources.icons8_menú_32_white;
            this.MenuButton.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.MenuButton.Location = new System.Drawing.Point(0, 0);
            this.MenuButton.Margin = new System.Windows.Forms.Padding(0);
            this.MenuButton.Name = "MenuButton";
            this.MenuButton.Size = new System.Drawing.Size(276, 41);
            this.MenuButton.TabIndex = 14;
            this.MenuButton.UseVisualStyleBackColor = false;
            this.MenuButton.Click += new System.EventHandler(this.MenuToggle);
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.LightGray;
            this.panel3.Dock = System.Windows.Forms.DockStyle.Right;
            this.panel3.Location = new System.Drawing.Point(276, 0);
            this.panel3.Margin = new System.Windows.Forms.Padding(0);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(4, 768);
            this.panel3.TabIndex = 0;
            // 
            // MenuTransition
            // 
            this.MenuTransition.Interval = 1;
            this.MenuTransition.Tick += new System.EventHandler(this.MenuTransition_Tick);
            // 
            // UPVTubeApp
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(120F, 120F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.ClientSize = new System.Drawing.Size(1366, 768);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.MaximizeBox = false;
            this.MaximumSize = new System.Drawing.Size(1366, 768);
            this.MinimumSize = new System.Drawing.Size(1366, 768);
            this.Name = "UPVTubeApp";
            this.Text = "UPVTubeApp";
            this.panel1.ResumeLayout(false);
            this.menuPanel.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button PerfilButton;
        private System.Windows.Forms.Button HomeButton;
        private System.Windows.Forms.Button EvaluarContenidoButton;
        private System.Windows.Forms.Button SubirContenidoButton;
        private System.Windows.Forms.Button HistorialButton;
        private System.Windows.Forms.Button LogOutButton;
        private System.Windows.Forms.Label Suscripciones;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Timer MenuTransition;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panelSuscripciones;
        private System.Windows.Forms.Button MenuButton;
        private System.Windows.Forms.Panel menuPanel;
    }
}

