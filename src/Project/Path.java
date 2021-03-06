package Project;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Path {
    public double[][] list;
    private ArrayList<QuinticSpline> m_splineList;
    double total_length = 0;

    @NotNull
    public Path(double[][] list){
        this.list = list;
        m_splineList = new ArrayList<>();
        Debug.print("Max Index: " + (list.length-1), 2);
        for (int i = 0; i <= list.length-2; i++){
            m_splineList.add(new QuinticSpline(list[i], list[i+1]));
            total_length += m_splineList.get(i).arc_length();
        }
        Debug.print("Total Length: " + total_length + " meters", 2);
    }

    public double getX(double t){
        return getSplineX(t*(double)m_splineList.size());
    }
    public double getY(double t){
        return getSplineY(t*(double)m_splineList.size());
    }
    public double getAngle(double t){
        return getSplineAngle(t*(double)m_splineList.size());
    }

    public double getSplineX(double t){
         int i = 0;
        if (t>1){
            i = (int)t;
            t -= i;
        }
        try {
            return m_splineList.get(i).getX(t);
        }
        catch (IndexOutOfBoundsException e)
        {
            return -1;
        }
    }
    public double getSplineY(double t){
        int i = 0;
        if (t>1){
            i = (int)t;
            t -= i;
        }
        try {
            return m_splineList.get(i).getY(t);
        }
        catch (IndexOutOfBoundsException e)
        {
            return -1;
        }
    }
    public double getSplineAngle(double t){
        int i = 0;
        if (t>1){
            i = (int)t;
            t -= i;
        }
        try {
            return m_splineList.get(i).getAngle(t);
        }
        catch (IndexOutOfBoundsException e)
        {
            return -1;
        }
    }
}
