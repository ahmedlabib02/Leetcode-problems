class MyCalendarTwo {
    ArrayList<Booking> bookings = new ArrayList<>();
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
    }
    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }

    public boolean book(int startTime, int endTime) {
        if(bookings.isEmpty())
        {
            bookings.add(new Booking(startTime, endTime, 1));
            return true;
        }
//        int smallestCommonBooking = binarySearch(startTime, endTime);


        //make deep copy
        ArrayList<Booking> backup = new ArrayList<>();
        for(Booking b: bookings)
        {
            backup.add(new Booking(b.start, b.end, b.count));
        }
        for(int i=0;i<bookings.size();i++)
        {
            Booking currBooking=bookings.get(i);
            if(bookings.get(i).end<=startTime) // no intersection
                continue;
            if(endTime<=currBooking.start){
                bookings.add(i, new Booking(startTime, endTime, 1));
                return true;
            }
            else if(currBooking.start<startTime) // split the currbooking
            {
                bookings.add(i,new Booking(currBooking.start, startTime, currBooking.count));
                currBooking.start= startTime;
            }
            else if(startTime<currBooking.start)
            {
                bookings.add(i , new Booking(startTime, currBooking.start, 1));
                startTime = currBooking.start;
            }
            //they start at the same time
            else if(currBooking.end>endTime)
            {
                bookings.add(i+1,new Booking(endTime, currBooking.end, currBooking.count));
                currBooking.end = endTime;
                currBooking.count++;
                if(currBooking.count==3)
                {
                    bookings=backup;
                    return false;
                }
                return true;
            }
            else if(currBooking.end<endTime)
            {
                currBooking.count++;
                if(currBooking.count==3)
                {
                    bookings=backup;
                    return false;
                }
                startTime = currBooking.end;
            }
            else // they end at the same time
            {
                currBooking.count++;
                if(currBooking.count==3)
                {
                    bookings=backup;
                    return false;
                }
                return true;
            }
            if(startTime>=endTime)
                break;
        }
        if(startTime<endTime)
            bookings.add(new Booking(startTime, endTime, 1));
        return true;
    }


    private int binarySearch(int start, int end)
    {
        int i=0;
        int j = bookings.size();
        while(i<j)
        {
           int mid = (j-i)/2 +i;
           Booking b = bookings.get(mid);
           if(b.start==start)
               return mid;
           if(b.start>=end)
               j=mid;
           else if(b.end<=start)
               i=mid+1;
           else // there is an intersection but I want to get the first intersection
            j= mid;
        }
        return i;
    }

    class Booking{
        public int start ;
        public int end;
        public int count;
        Booking(int s, int e, int c)
        {
            start = s;
            end = e;
            count = c;
        }

        public String toString()
        {
            return "("+start+","+end+","+count+")";
        }

    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */