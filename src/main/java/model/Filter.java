package model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filter {
    private String product;
    private String brandcheckbox;
    private String maxsum;
    //private Object[] f;
   // public  Filter(String q, String b, String s){
    // f=new Object[]{q , b ,s };
   // }
    public String getProduct(){return product;}
    public String getBrandCheckBox(){return brandcheckbox;}
    public String getMaxSum(){return maxsum;}
    //public Object[] getFilter(){return f;}

    public void setProduct(String d){ product =d;}
    public void setbrandcheckbox(String d){ brandcheckbox=d;}
    public void setMaxsum(String d){ maxsum=d;}
   // @Override
  //  public String toString(){
        //return "{Query "+ f[0]+", BrandCheckBox "+f[1]+", MaxSum "+f[2]+'\''+'}';
   //}
}
