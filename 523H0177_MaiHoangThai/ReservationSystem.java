import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class ReservationSystem {
    private ArrayList<Accommodation> accommodations;

    // Requirement 1: Load data
    public ReservationSystem(String accPath, String roomPath, String roomOfAccPath) {
        this.accommodations = loadAccommodations(accPath, roomPath, roomOfAccPath);
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    // Requirement 1
    public ArrayList<Accommodation> loadAccommodations(String accPath, String roomPath, String roomOfAccPath) {
        ArrayList<Accommodation> accomList = new ArrayList<>();
        ArrayList<Room> roomList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(roomPath))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int a = Integer.valueOf(parts[0]);
                String b = parts[1];
                int c = Integer.valueOf(parts[2]);
                String d = parts[3];
                int e = Integer.valueOf(parts[4]);
                int f = Integer.valueOf(parts[5]);
                double g = Double.valueOf(parts[6]);
                double h = Double.valueOf(parts[7]);

                Room ro = new Room(a, b, c, d, e, f, g, h);
                roomList.add(ro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(accPath))) {
            
            String line;
            while ((line = br.readLine()) != null) {
               
                String[] parts = line.split(",");
                // resort
                if(parts.length == 7){
                    int a = Integer.valueOf(parts[0]);
                    String b = parts[1];
                    String c = parts[2];
                    String d = parts[3];
                    float e = Float.valueOf(parts[6]);
                    int f = Integer.valueOf(parts[4]);
                    boolean g;
                    if(parts[5].equals("yes")) g = true;
                    else g = false;

                    Resort rs = new Resort(a, b, c, d, e, f, g);
                    accomList.add(rs);
                }
                // homestay
                else if (parts.length == 5){
                    int a = Integer.valueOf(parts[0]);
                    String b = parts[1];
                    String c = parts[2];
                    String d = parts[3];
                    float e = Float.valueOf(parts[4]);

                    Homestay hs = new Homestay(a, b, c, d, e);
                    accomList.add(hs);
                }
                // hotel
                else if (parts.length == 6){
                    int a = Integer.valueOf(parts[0]);
                    String b = parts[1];
                    String c = parts[2];
                    String d = parts[3];
                    float e = Float.valueOf(parts[5]);
                    int f = Integer.valueOf(parts[4]);


                    Hotel ho = new Hotel(a, b, c, d, e, f);
                    accomList.add(ho);
                }
                // villa
                else if (parts.length == 10){
                    int a = Integer.valueOf(parts[0]);
                    String b = parts[1];
                    String c = parts[2];
                    String d = parts[3];
                    boolean e; 
                    if(parts[4].equals("yes")) e = true;
                    else e = false;
                    boolean f;
                    if(parts[5].equals("yes")) f = true;
                    else f = false;
                    boolean g;
                    if(parts[6].equals("yes")) g = true;
                    else g = false;
                    boolean h;
                    if(parts[7].equals("yes")) h = true;
                    else h = false;
                    int i = Integer.valueOf(parts[8]);
                    int j = Integer.valueOf(parts[9]);
                    

                    Villa vl = new Villa(a, b, c, d, e, f, g, h, i, j);
                    accomList.add(vl);
                }
                // cruise ship
                else if (parts.length == 11){
                    int a = Integer.valueOf(parts[0]);
                    String b = parts[1];
                    String c = parts[2];
                    String d = parts[3];
                    boolean e; 
                    if(parts[4].equals("yes")) e = true;
                    else e = false;
                    boolean f;
                    if(parts[5].equals("yes")) f = true;
                    else f = false;
                    boolean g;
                    if(parts[6].equals("yes")) g = true;
                    else g = false;
                    boolean h;
                    if(parts[7].equals("yes")) h = true;
                    else h = false;
                    int i = Integer.valueOf(parts[9]);
                    int j = Integer.valueOf(parts[10]);
                    boolean k;
                    if(parts[8].equals("yes")) k = true;
                    else k = false;

                    CruiseShip cs = new CruiseShip(a, b, c, d, e, f, g, h, i, j, k);
                    accomList.add(cs);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CHINH LAI CAI NAY, PLEASEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        try (BufferedReader br = new BufferedReader(new FileReader(roomOfAccPath))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                for(Accommodation accom : accomList){
                    if(accom instanceof CommonAccommodation){
                        CommonAccommodation temp2 = (CommonAccommodation) accom;
                        if(temp2.getMaSoDinhDanh() == Integer.valueOf(parts[0])){
                            // add room co id la part[0]
                            for(Room room: roomList){
                                if(room.getMaDinhDanh() == Integer.valueOf(parts[1])){
                                    temp2.danhSachPhong.add(room);
                                }
                            }
                        }
                    }
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return accomList;
    }

    // Requirement 2
    public ArrayList<Accommodation> searchForRoom(String city, int numOfPeople) {
        ArrayList<Accommodation> accomList = new ArrayList<>();
        ArrayList<Accommodation> luxuryList = new ArrayList<>();
        ArrayList<Accommodation> commonList = new ArrayList<>();

        for(Accommodation temp : accommodations){
            if(temp instanceof LuxuryAccommodation && city.equals(temp.thanhPho)){
                luxuryList.add(temp);
            }
        }
        for(Accommodation temp : accommodations){
            if(temp instanceof CommonAccommodation){
                CommonAccommodation temp2 = (CommonAccommodation) temp;
                ArrayList<Room> danhSachPhong = temp2.getDanhSachPhong();
                for (Room room : danhSachPhong) {
                    if(city.equals(temp.thanhPho) && numOfPeople <= room.soLuongToiDa){
                        commonList.add(temp);
                    }
                }
            }
        }

        sortAccommodationListForReq2(luxuryList);
        sortAccommodationListForReq2(commonList);

        for(Accommodation temp : luxuryList){
            accomList.add(temp);
        }
        for(Accommodation temp : commonList){
            accomList.add(temp);
        }
        return accomList;
    }

    // sort function for rq2
    public static void sortAccommodationListForReq2(ArrayList<Accommodation> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).noiLuuTru.compareTo(list.get(j + 1).noiLuuTru) > 0) {
                    Accommodation temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Requirement 3
    public ArrayList<Accommodation> searchForRoomByRange(String reservationPath, double priceFrom, double priceTo,
            Date checkin, Date checkout, String city, int numOfPeople) {
        ArrayList<Accommodation> accomList = new ArrayList<>();
        ArrayList<Reservation> reservated = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(reservationPath))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int reservationID;
                int accomID;
                int roomID;
                long reservatedRoomCheckin;
                long reservatedRoomCheckout;
                // common accommodation
                if(parts.length == 5){
                    reservationID = Integer.valueOf(parts[0]);
                    accomID = Integer.valueOf(parts[1]);
                    roomID = Integer.valueOf(parts[2]);
                    reservatedRoomCheckin = Long.valueOf(parts[3]);
                    reservatedRoomCheckout = Long.valueOf(parts[4]);
                    Reservation re = new Reservation(reservationID, accomID, roomID, new Date(reservatedRoomCheckin), new Date(reservatedRoomCheckout));
                    reservated.add(re);

                }
                // luxury accommodation
                else if(parts.length == 4){
                    reservationID = Integer.valueOf(parts[0]);
                    accomID = Integer.valueOf(parts[1]);
                    reservatedRoomCheckin = Long.valueOf(parts[2]);
                    reservatedRoomCheckout = Long.valueOf(parts[3]);
                    Reservation re = new Reservation(reservationID, accomID, -1, new Date(reservatedRoomCheckin), new Date(reservatedRoomCheckout));
                    reservated.add(re);
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        for(Accommodation a : accommodations){
            if(a.getThanhPho().equals(city)){
                // common
                if(a instanceof CommonAccommodation){
                    CommonAccommodation b = (CommonAccommodation)a;
                    for (Room r : b.getDanhSachPhong()){
                        if((priceFrom <= r.getChiPhiPhong1Dem()) && (r.getChiPhiPhong1Dem() <= priceTo) && (numOfPeople <= r.getSoLuongToiDa()) && (r.getSoLuongToiDa() <= numOfPeople + 2)){
                            boolean boo = false;
                            for(Reservation temp : reservated){
                                if(temp.getAccId() == b.getMaSoDinhDanh() && temp.getRoomId() == r.getMaDinhDanh()){
                                    boo = true;
                                    if(temp.getCheckin().after(checkout) || temp.getCheckout().before(checkin)){
                                        if(checkout.after(checkin)){
                                            accomList.add(a);
                                        }
                                    }
                                }
                            }
                            if(boo == false){
                                accomList.add(a);
                            }
                        }
                    }
                }
                // luxury
                else if(a instanceof LuxuryAccommodation){
                    LuxuryAccommodation b = (LuxuryAccommodation) a;
                    if(priceFrom <= b.getChiPhiMotDem() && b.getChiPhiMotDem() <= priceTo && numOfPeople <= b.getSoNguoiToiDa() && b.getSoNguoiToiDa() <= numOfPeople + 2){
                        boolean boo = false;
                        for(Reservation temp : reservated){
                            if(temp.getAccId() == b.getMaSoDinhDanh()){
                                boo = true;
                                if(temp.getCheckin().after(checkout) || temp.getCheckout().before(checkin)){
                                    if(checkout.after(checkin)){
                                        accomList.add(a);
                                    }
                                }
                            }
                        }
                        if(boo == false){
                            accomList.add(a);
                        }
                    }
                }
            }
        }

        sortAccommodationListForReq3(accomList);

        return accomList;
    }
    // sort function for rq3
    public static void sortAccommodationListForReq3(ArrayList<Accommodation> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j + 1).noiLuuTru.compareTo(list.get(j).noiLuuTru) > 0) {
                    Accommodation temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Requirement 4
    public ArrayList<Accommodation> searchInAdvance(String city, Integer numOfPeople, String roomType,
            Boolean privatePool, Integer starQuality, Boolean freeBreakfast, Boolean privateBar) {
        ArrayList<Accommodation> criteriaList1 = new ArrayList<>();
        ArrayList<Accommodation> criteriaList2 = new ArrayList<>();
        ArrayList<Accommodation> criteriaList3 = new ArrayList<>();
        ArrayList<Accommodation> criteriaList4 = new ArrayList<>();
        ArrayList<Accommodation> criteriaList5 = new ArrayList<>();
        ArrayList<Accommodation> result = new ArrayList<>();

        boolean check1 = true;
        boolean check2 = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;

        for(Accommodation a : accommodations){
            if(a.getThanhPho().equals(city)){
                // criteria 1
                if(roomType != null){
                    if(a instanceof CommonAccommodation){
                        CommonAccommodation b = (CommonAccommodation) a;
                        for(Room r : b.getDanhSachPhong()){
                            if(r.getSoLuongToiDa() >= numOfPeople && r.getLoaiPhong().equals(roomType)){
                                criteriaList1.add(a);
                            }
                        }
                    }
                } else if(roomType == null) check1 = false;
                
                // criteria 2
                if(privatePool != null){
                    if(a instanceof CommonAccommodation){
                        CommonAccommodation b = (CommonAccommodation) a;
                        if(b instanceof Resort){
                            Resort c = (Resort) b;
                            for(Room r : c.getDanhSachPhong()){
                                if(r.getSoLuongToiDa() >= numOfPeople && c.getBeBoiCaNhan() == privatePool){
                                    criteriaList2.add(a);
                                }
                            }
                        }
                    } 
                    else if(a instanceof LuxuryAccommodation){
                        LuxuryAccommodation b = (LuxuryAccommodation) a;
                        if(b instanceof Villa){
                            Villa c = (Villa) b;
                            if(c.getSoNguoiToiDa() >= numOfPeople && c.getBeBoiCaNhan() == privatePool){
                                criteriaList2.add(a);
                            }
                        }
                        else if(b instanceof CruiseShip){
                            CruiseShip c = (CruiseShip) b;
                            if(c.getSoNguoiToiDa() >= numOfPeople && c.getBeBoiCaNhan() == privatePool){
                                criteriaList2.add(a);
                            }
                        }
                    }
                } else if(privatePool == null) check2 = false;

                // criteria 3
                if(starQuality != null){
                    if(a instanceof CommonAccommodation){
                        CommonAccommodation b = (CommonAccommodation) a;
                        if(b instanceof Hotel){
                            Hotel c = (Hotel) b;
                            for(Room r : c.getDanhSachPhong()){
                                if(r.getSoLuongToiDa() >= numOfPeople && c.getSoSaoChatLuongDichVu() == starQuality){
                                    criteriaList3.add(a);
                                }
                            }
                        }
                        else if(b instanceof Resort){
                            Resort c = (Resort) b;
                            for(Room r : c.getDanhSachPhong()){
                                if(r.getSoLuongToiDa() >= numOfPeople && c.getSoSao() == starQuality){
                                    criteriaList3.add(a);
                                }
                            }
                        }
                    }
                } else if(starQuality == null) check3 = false;
                
                // criteria 4
                if(freeBreakfast != null){
                    if(a instanceof LuxuryAccommodation){
                        LuxuryAccommodation b =(LuxuryAccommodation) a;
                        if(b instanceof Villa){
                            Villa c = (Villa) b;
                            if(c.getSoNguoiToiDa() >= numOfPeople && c.getMienPhiBuaSang() == freeBreakfast){
                                criteriaList4.add(a);
                            }
                        }
                        else if(b instanceof CruiseShip){
                            CruiseShip c = (CruiseShip) b;
                            if(c.getSoNguoiToiDa() >= numOfPeople && c.getMienPhiBuaSang() == freeBreakfast){
                                criteriaList4.add(a);
                            }
                        }
                    }
                } else if(freeBreakfast == null) check4 = false;

                // criteria 5
                if(privateBar != null){
                    if(a instanceof LuxuryAccommodation){
                        LuxuryAccommodation b =(LuxuryAccommodation) a;
                        if(b instanceof CruiseShip){
                            CruiseShip c = (CruiseShip) b;
                            if(c.getSoNguoiToiDa() >= numOfPeople && c.getBarRiengTu() == privateBar){
                                criteriaList5.add(a);
                            }
                        }
                    }
                } else if(privateBar == null) check5 = false;
            }
        }
        // intersection
        // add 1
        if(check1) result.addAll(criteriaList1);
        else if(check2) result.addAll(criteriaList2);
        else if(check3) result.addAll(criteriaList3);
        else if(check4) result.addAll(criteriaList4);
        else if(check5) result.addAll(criteriaList5);
        // retain
        if(check1) result.retainAll(criteriaList1);
        if(check2) result.retainAll(criteriaList2);
        if(check3) result.retainAll(criteriaList3);
        if(check4) result.retainAll(criteriaList4);
        if(check5) result.retainAll(criteriaList5);

        return result;
    }

    // Requirement 5
    public double performReservation(String reservationPath, Accommodation acc, Room room, Date checkin, Date checkout)
            throws Exception {
        double result = 0;
        ArrayList<Reservation> reservated = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(reservationPath))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int reservationID;
                int accomID;
                int roomID;
                long reservatedRoomCheckin;
                long reservatedRoomCheckout;
                // common accommodation
                if(parts.length == 5){
                    reservationID = Integer.valueOf(parts[0]);
                    accomID = Integer.valueOf(parts[1]);
                    roomID = Integer.valueOf(parts[2]);
                    reservatedRoomCheckin = Long.valueOf(parts[3]);
                    reservatedRoomCheckout = Long.valueOf(parts[4]);
                    Reservation re = new Reservation(reservationID, accomID, roomID, new Date(reservatedRoomCheckin), new Date(reservatedRoomCheckout));
                    reservated.add(re);

                }
                // luxury accommodation
                else if(parts.length == 4){
                    reservationID = Integer.valueOf(parts[0]);
                    accomID = Integer.valueOf(parts[1]);
                    reservatedRoomCheckin = Long.valueOf(parts[2]);
                    reservatedRoomCheckout = Long.valueOf(parts[3]);
                    Reservation re = new Reservation(reservationID, accomID, -1, new Date(reservatedRoomCheckin), new Date(reservatedRoomCheckout));
                    reservated.add(re);
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        boolean boo = false;
        for(Reservation re : reservated){   
            if(re.getAccId() == acc.getMaSoDinhDanh() && re.getRoomId() == room.getMaDinhDanh()){
                if(re.getCheckin().after(checkout) || re.getCheckout().before(checkin)){
                    if(checkin.before(checkout)){
                        for(Accommodation a : accommodations){
                            if(a instanceof CommonAccommodation){
                                CommonAccommodation b = (CommonAccommodation) a;
                                if(b.getMaSoDinhDanh() == acc.getMaSoDinhDanh()){
                                    for(Room r : b.getDanhSachPhong()){
                                        if(r.getMaDinhDanh() == room.getMaDinhDanh()){
                                            boo = true;
                                            // dat thanh cong
                                            result = diffBetweenDays(checkin.getTime(), checkout.getTime())*r.getChiPhiPhong1Dem()*(1 + 0.08);
                                            BufferedWriter writer = new BufferedWriter(new FileWriter(reservationPath,true));
                                            writer.newLine();
                                            String str = String.format("%s,%s,%s,%s,%s", reservated.size()+1, acc.getMaSoDinhDanh(), room.getMaDinhDanh(), checkin.getTime(), checkout.getTime());
                                            writer.write(str);
                                            writer.close();
                                            return result;
                                        }
                                       
                                    }
                                }
                            }
                        }
                        
                    }
                }
                else {
                    throw new Exception("The room has already been booked during this time period.");
                }
            } 
        }
        if(boo == false){
            for(Accommodation a : accommodations){
                if(a instanceof CommonAccommodation){
                    CommonAccommodation b = (CommonAccommodation) a;
                    if(b.getMaSoDinhDanh() == acc.getMaSoDinhDanh()){
                        for(Room r : b.getDanhSachPhong()){
                            if(r.getMaDinhDanh() == room.getMaDinhDanh()){
                                boo = true;
                                // dat thanh cong
                                result = diffBetweenDays(checkin.getTime(), checkout.getTime())*r.getChiPhiPhong1Dem()*(1 + 0.08);
                                BufferedWriter writer = new BufferedWriter(new FileWriter(reservationPath,true));
                                writer.newLine();
                                String str = String.format("%s,%s,%s,%s,%s",reservated.size()+1, acc.getMaSoDinhDanh(), room.getMaDinhDanh(), checkin.getTime(), checkout.getTime());
                                writer.write(str);
                                writer.close();
                                return result;
                            }
                           
                        }
                    }
                }
            }
        }
        return result;
    }

    // Helper functions for req 5
    public long diffBetweenDays(long dateStart, long dateEnd) {
        Date date = new Date(dateStart * 1000);
        Date date1 = new Date(dateEnd * 1000);

        date = removeTime(date);
        date1 = removeTime(date1);

        long diff = Math.abs(date1.getTime() - date.getTime());
        long numOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return numOfDays;
    }

    private Date removeTime(Date date) {
        long time = date.getTime();
        long timeWithoutTime = time - (time % (24 * 60 * 60 * 1000));
        return new Date(timeWithoutTime);
    }
}