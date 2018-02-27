package ng.transnova.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t")
	, @NamedQuery(name = "Trip.findByTripId", query = "SELECT t FROM Trip t WHERE t.tripId = :tripId")
	, @NamedQuery(name = "Trip.findByTripTime", query = "SELECT t FROM Trip t WHERE t.tripTime = :tripTime")
	, @NamedQuery(name = "Trip.findByTripPrice", query = "SELECT t FROM Trip t WHERE t.tripPrice = :tripPrice")})
public class Trip implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "tripId")
	private Integer tripId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "tripTime")
	@Temporal(TemporalType.TIME)
	private Date tripTime;
	@Basic(optional = false)
	@NotNull
	@Column(name = "tripPrice")
	private float tripPrice;
	@JoinColumn(name = "destination_station_id", referencedColumnName = "station_id")
	@ManyToOne(optional = false)
	private Station destinationStationId;
	@JoinColumn(name = "origin_station_id", referencedColumnName = "station_id")
	@ManyToOne(optional = false)
	private Station originStationId;

	public Trip()
	{
	}

	public Trip(Integer tripId)
	{
		this.tripId = tripId;
	}

	public Trip(Integer tripId, Date tripTime, float tripPrice)
	{
		this.tripId = tripId;
		this.tripTime = tripTime;
		this.tripPrice = tripPrice;
	}

	public Integer getTripId()
	{
		return tripId;
	}

	public void setTripId(Integer tripId)
	{
		this.tripId = tripId;
	}

	public Date getTripTime()
	{
		return tripTime;
	}

	public void setTripTime(Date tripTime)
	{
		this.tripTime = tripTime;
	}

	public float getTripPrice()
	{
		return tripPrice;
	}

	public void setTripPrice(float tripPrice)
	{
		this.tripPrice = tripPrice;
	}

	public Station getDestinationStationId()
	{
		return destinationStationId;
	}

	public void setDestinationStationId(Station destinationStationId)
	{
		this.destinationStationId = destinationStationId;
	}

	public Station getOriginStationId()
	{
		return originStationId;
	}

	public void setOriginStationId(Station originStationId)
	{
		this.originStationId = originStationId;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (tripId != null ? tripId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Trip)) {
			return false;
		}
		Trip other = (Trip) object;
		if ((this.tripId == null && other.tripId != null) || (this.tripId != null && !this.tripId.equals(other.tripId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "ng.transnova.models.Trip[ tripId=" + tripId + " ]";
	}

}
