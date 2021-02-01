package by.bsuir.photo.studio.api.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Hall {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Length(max = 36, min = 36)
    private String id;

    private String name;

    private String description;

    private String weekdayCost;

    private String weekendCost;

    private String image;

    private String imageLink;

    @Enumerated(EnumType.STRING)
    private TimeStatus timeStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeekdayCost() {
        return weekdayCost;
    }

    public void setWeekdayCost(String weekdayCost) {
        this.weekdayCost = weekdayCost;
    }

    public String getWeekendCost() {
        return weekendCost;
    }

    public void setWeekendCost(String weekendCost) {
        this.weekendCost = weekendCost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public TimeStatus getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(TimeStatus timeStatus) {
        this.timeStatus = timeStatus;
    }
}
