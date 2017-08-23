package massive.task.com.model.pojo;

import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by Anand on 8/19/2017.
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)

public class Location implements Serializable{
    private String address;

    private Double lng;

    private Double lat;

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public Double getLng ()
    {
        return lng;
    }

    public void setLng (Double lng)
    {
        this.lng = lng;
    }

    public Double getLat ()
    {
        return lat;
    }

    public void setLat (Double lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [address = "+address+", lng = "+lng+", lat = "+lat+"]";
    }
}
