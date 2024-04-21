package lib;
import java.util.LinkedList;
import java.util.List;

public class FamilyData {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;

    public FamilyData() {
        this.childNames = new LinkedList<>();
        this.childIdNumbers = new LinkedList<>();
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        this.childNames.add(childName);
        this.childIdNumbers.add(childIdNumber);
    }

    public boolean isSingle() {
        return spouseIdNumber == null || spouseIdNumber.isEmpty();
    }

    public int getNumChildren() {
        return childIdNumbers.size();
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    public void setSpouseIdNumber(String spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }

    public void setChildIdNumbers(List<String> childIdNumbers) {
        this.childIdNumbers = childIdNumbers;
    }
    
}