package ng.transnova.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Station")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s")
	, @NamedQuery(name = "Station.findByStationId", query = "SELECT s FROM Station s WHERE s.stationId = :stationId")
	, @NamedQuery(name = "Station.findByStationName", query = "SELECT s FROM Station s WHERE s.stationName = :stationName")})
public class Station implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "station_id")
	private Integer stationId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "station_name")
	private String stationName;
	@Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "station_address")
	private String stationAddress;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sourceStationId")
	private Collection<Ticket> ticketCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationStationId")
	private Collection<Ticket> ticketCollection1;

	public Station()
	{
	}

	public Station(Integer stationId)
	{
		this.stationId = stationId;
	}

	public Station(Integer stationId, String stationName, String stationAddress)
	{
		this.stationId = stationId;
		this.stationName = stationName;
		this.stationAddress = stationAddress;
	}

	public Integer getStationId()
	{
		return stationId;
	}

	public void setStationId(Integer stationId)
	{
		this.stationId = stationId;
	}

	public String getStationName()
	{
		return stationName;
	}

	public void setStationName(String stationName)
	{
		this.stationName = stationName;
	}

	public String getStationAddress()
	{
		return stationAddress;
	}

	public void setStationAddress(String stationAddress)
	{
		this.stationAddress = stationAddress;
	}

	@XmlTransient
	public Collection<Ticket> getTicketCollection()
	{
		return ticketCollection;
	}

	public void setTicketCollection(Collection<Ticket> ticketCollection)
	{
		this.ticketCollection = ticketCollection;
	}

	@XmlTransient
	public Collection<Ticket> getTicketCollection1()
	{
		return ticketCollection1;
	}

	public void setTicketCollection1(Collection<Ticket> ticketCollection1)
	{
		this.ticketCollection1 = ticketCollection1;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (stationId != null ? stationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Station)) {
			return false;
		}
		Station other = (Station) object;
		if ((this.stationId == null && other.stationId != null) || (this.stationId != null && !this.stationId.equals(other.stationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.transnova.models.Station[ stationId=" + stationId + " ]";
	}
	
}
