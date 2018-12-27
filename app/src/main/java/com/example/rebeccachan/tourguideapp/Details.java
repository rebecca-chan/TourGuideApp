package com.example.rebeccachan.tourguideapp;

/**
 * {@link Details} represents the information about sights, activities, restaurants,
 * lodging, and events. It contains the name, location, details, description and image for each item.
 */
public class Details {

    /** Name for ListView item object **/
    private String mName;

    /** Quick details for object **/
    private String mDetails;

    /** More detailed description of object, displayed in {@link DetailsActivity} **/
    private String mDescription;

    /** Location of object, usually a hyperlink if object has address **/
    private String mLocation;

    /** Image resource ID for the object **/
    private int mImageResourceId;

    /**
     * Create an Details object
     *
     * @param name is the title or name associated with Details object
     *
     * @param details is a short one-line detail about the object to draw interest from the user
     *
     * @param imageResourceId is the resource ID associated with the object
     *
     * @param description is a small paragraph about the object, either fun facts or info about amenities
     *
     * @param location is the address of the object, usually a hyperlink leading to a Maps app
     */
    public Details(String name, String details, int imageResourceId, String description, String location) {
        mName = name;
        mDetails = details;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mLocation = location;
    }

    /** Get the Name of the object **/
    public String getName() {
        return mName;
    }

    /** Get the Details of the object **/
    public String getDetails() {
        return mDetails;
    }

    /** Get the Description of the object **/
    public String getDescription() {
        return mDescription;
    }

    /** Get the Location of the object **/
    public String getLocation() {
        return mLocation;
    }

    /** Get the Image resource ID of the object **/
    public int getImageResourceId() {
        return mImageResourceId;
    }
    }
