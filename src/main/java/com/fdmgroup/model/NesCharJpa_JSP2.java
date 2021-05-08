package com.fdmgroup.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.NamedQueries;
	import javax.persistence.NamedQuery;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;


	@Entity
	@Table(name="NesCharJpa_JSP2")
	@NamedQueries( {
		@NamedQuery(name = "n.findByCharID", query="SELECT n FROM NesCharJpa_JSP2 n WHERE n.charID = :nIDParam"),
		@NamedQuery(name = "n.findByCharName", query="SELECT n FROM NesCharJpa_JSP2 n WHERE n.charName = :nCharName"),
		@NamedQuery(name = "n.findAllChar", query="SELECT n FROM NesCharJpa_JSP2 n")
	} )
	public class NesCharJpa_JSP2 {

		@Id
		@SequenceGenerator(name = "charSequenceJSP", sequenceName = "NES_CHAR_SEQ_JSP2", initialValue = 1, allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charSequenceJSP")
		@Column(name="charID")
		private int charID;
		
		@Column(name = "charName")
		private String charName;
		
		public NesCharJpa_JSP2() {
			super();
		}

		public int getCharID() {
			return charID;
		}

		public String getCharName() {
			return charName;
		}

		public void setCharName(String charName) {
			this.charName = charName;
		}

		@Override
		public String toString() {
			return "NesCharJpa [charID=" + charID + ", charName=" + charName + "]";
		}
}

