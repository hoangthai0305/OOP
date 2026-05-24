# OOP - Accommodation Reservation System

## Tong quan

Day la bai tap lon mon Lap Trinh Huong Doi Tuong, mo phong he thong quan ly va dat cho luu tru. Du an doc du lieu tu cac file CSV, tao danh sach co so luu tru theo mo hinh huong doi tuong, ho tro tim kiem theo nhieu tieu chi va thuc hien dat phong.

README nay mo ta dung theo trang thai repo hien tai, khong viet lai theo de bai ly tuong.

## Chuc nang da co

Du an hien tai da cai dat cac yeu cau sau:

1. Nap du lieu accommodation, room va quan he room-accommodation tu CSV.
2. Tim co so luu tru theo thanh pho va so nguoi.
3. Tim co so luu tru theo khoang gia, thoi gian va tinh trang da dat.
4. Tim kiem nang cao theo cac tieu chi:
   - loai phong
   - ho boi rieng
   - so sao
   - bua sang mien phi
   - bar rieng
5. Thuc hien dat phong va ghi them reservation vao file CSV.

`Main.java` va `Main_1.java` dang su dung cac requirement `1` den `5`. Mang ten file output co khai bao `Req6.txt`, nhung entry point hien tai khong co case xu ly requirement 6.

## Mo hinh doi tuong

He thong xoay quanh cac lop sau:

- `Accommodation`: lop truu tuong goc cho moi co so luu tru.
- `CommonAccommodation`: nhom co phong (`Hotel`, `Homestay`, `Resort`).
- `LuxuryAccommodation`: nhom luu tru cao cap (`Villa`, `CruiseShip`).
- `Room`: thong tin phong, suc chua, loai phong, gia theo dem.
- `Reservation`: thong tin dat cho.
- `ReservationSystem`: lop nghiep vu trung tam, xu ly doc file, tim kiem va dat phong.

## Cau truc thu muc

```text
.
|-- 523H0177_MaiHoangThai/
|   |-- Accommodation.java
|   |-- CommonAccommodation.java
|   |-- LuxuryAccommodation.java
|   |-- Hotel.java
|   |-- Homestay.java
|   |-- Resort.java
|   |-- Villa.java
|   |-- CruiseShip.java
|   |-- Room.java
|   `-- ReservationSystem.java
|-- SourceCode/
|   |-- Main.java
|   |-- Main_1.java
|   |-- Reservation.java
|   |-- Test.java
|   |-- data/
|   |-- data_1/
|   |-- expected_output/
|   |-- expected_output_1/
|   |-- output/
|   `-- output_1/
|-- AssignmentRequirements.pdf
`-- README.md
```

Ghi chu:

- Source bi tach thanh 2 noi: lop nghiep vu nam trong `523H0177_MaiHoangThai/`, con file chay va du lieu nam trong `SourceCode/`.
- Repo dang kem san file `.class`, output mau va mot so file zip/phien ban nop bai.

## Du lieu dau vao

Bo du lieu chinh nam trong `SourceCode/data/`:

- `accommodation.csv`: thong tin cac loai luu tru.
- `room_type.csv`: thong tin phong.
- `room_in_accommodation.csv`: mapping phong vao accommodation.
- `reservation_3.csv`: du lieu phuc vu tim kiem theo khoang thoi gian.
- `reservation_5.csv`: du lieu phuc vu dat phong.

Bo du lieu phu nam trong `SourceCode/data_1/` va duoc `Main_1.java` su dung.

## Cach chay

### Yeu cau moi truong

- JDK 21
- Windows PowerShell hoac terminal co the goi `javac` / `java`

Luu y quan trong: trong workspace hien tai, lenh `java` trong `PATH` dang tro toi JRE 8, trong khi cac file `.class` co san duoc build bang Java 21. Neu may cua ban gap loi `UnsupportedClassVersionError`, hay dung dung binary Java 21 hoac sua lai `PATH`.

### Bien dich lai tu source

Chay tu thu muc goc cua repo:

```powershell
& "C:\Program Files\Common Files\Oracle\Java\javapath\javac.exe" `
  -d SourceCode `
  523H0177_MaiHoangThai\*.java `
  SourceCode\Reservation.java `
  SourceCode\Main.java `
  SourceCode\Main_1.java `
  SourceCode\Test.java
```

### Chay bo du lieu chinh

```powershell
Set-Location SourceCode
& "C:\Program Files\Common Files\Oracle\Java\javapath\java.exe" Main 1 2 3 4 5
```

Ket qua duoc ghi vao:

- `SourceCode/output/Req1.txt`
- `SourceCode/output/Req2_1.txt`
- `SourceCode/output/Req2_2.txt`
- `SourceCode/output/Req3_1.txt`
- `SourceCode/output/Req3_2.txt`
- `SourceCode/output/Req4_1.txt`
- `SourceCode/output/Req4_2.txt`
- `SourceCode/output/Req5.txt`

### Chay bo du lieu phu

```powershell
Set-Location SourceCode
& "C:\Program Files\Common Files\Oracle\Java\javapath\java.exe" Main_1 1 2 3 4
```

Ket qua duoc ghi vao `SourceCode/output_1/`.

## Doi chieu ket qua

Repo da kem san:

- `SourceCode/expected_output/`
- `SourceCode/expected_output_1/`

De so sanh voi:

- `SourceCode/output/`
- `SourceCode/output_1/`

## Hanh vi dat phong

Requirement 5 thuc hien cac buoc:

1. Doc file reservation hien co.
2. Kiem tra phong con trong khoang thoi gian yeu cau.
3. Tinh tong tien theo so ngay va gia phong.
4. Cong them `8%` vao tong tien.
5. Ghi them dong moi vao file reservation.

Vi vay, moi lan chay requirement 5 co the lam thay doi `SourceCode/data/reservation_5.csv`.

## Trang thai repo

Day la mot du an Java thuan:

- khong dung package
- khong dung Maven/Gradle
- du lieu va output duoc doc/ghi truc tiep bang file CSV/TXT

Neu muon don repo hon ve sau, co the gop source ve mot thu muc, bo file `.class` khoi version control va them script build/run rieng. Tuy nhien README nay dang uu tien mo ta dung hien trang de co the clone va chay ngay.
