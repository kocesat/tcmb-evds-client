package com.kocesat.project.evds.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "document")
public class EvdsResponseDocument {
    private int totalCount;
    private List<EvdsItem> items;

    @XmlElement(name = "totalCount")
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @XmlElement(name = "items")
    public List<EvdsItem> getItems() {
        return items;
    }

    public void setItems(List<EvdsItem> items) {
        this.items = items;
    }
}
