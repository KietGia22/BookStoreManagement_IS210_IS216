
# PHẦN MỀM QUẢN LÝ CỬA HÀNG SÁCH

## Giới thiệu đồ án
 
<p align-items: center>Phần mềm Quản lý nhà sách được xây dựng nhằm mục đích phục vụ việc mua bán, nhập và quản lý sách được thực hiện một cách tự động, dễ dàng và chính xác hơn. Từ đó giảm bớt lượng công việc của nhân viên và chủ nhà sách phải làm, tăng năng suất công việc và đem lại lợi nhuận cho các cửa hàng sách quy mô vừa và nhỏ. </p>

## Thành viên
 |Tên                   | MSSV     |
 |----------------------| ---------|
 |Vương Thanh Linh      | 21521082 |
 |Nguyễn Xuân Tài       | 20520744 |
 |Nguyễn Thanh Tuấn     | 20520846 |
 |Nguyễn Trần Gia Kiệt  | 21522258 |

## Các chức năng trong hệ thống
>- Quản lý tài khoản nhân viên
>- Quản lý nhà phân phối
>- Quản lý sách trong nhà sách
>- Quản lý thể loại sách
>- Quản lý khách hàng
>- Quản lý hoá đơn
>- Quản lý nhập sách
>- Xem lương nhân viên
>- Chắm công 
>- Xem báo cáo
>- In hoá đơn cho khách đăng kí
>- In hoá đơn cho khách chưa đăng kí

## Các công nghệ, ngôn ngữ sử dụng
>- Ngôn ngữ lập trình: `JAVA`
>- Hệ quản trị CSDL: `Oracle` với ngôn ngữ `PL/SQL`
>- IDE đã sử dụng: `Netbeans`
>- Phần mềm để sử dụng Oracle: `SQLDeveloper`
>- Quản lý dự án: `Github`
>- Tạo report: `IReport`

## Yêu cầu hệ thống
>- JDK 19
>- ojdbc11.jar
>- đã cài plugin tao report
>- LGoodDatePicker để sử dụng các thứ liên quan tới ngày tháng năm

## Các bước để khởi chạy phần mềm

- B1: Clone repo này về 
- B2: Hãy đảm bảo máy bạn đã có các phần mềm để khởi chạy Oracle
- B3: Tạo một user/password mới, chạy lần lượt file `createTable.sql` ->  `seq_constraint_trigger.sql` -> `function.sql` -> `procedure.sql` -> `data.sql` -> `baocao.sql`. **NHỚ COMMIT ĐỂ CHƯƠNG TRÌNH CÓ THỂ CHẠY ỔN ĐỊNH**
- B4: Mở Netbeans thêm các thư viện trong `Library` và cài các plugin trong file `Lab6.pdf`
- B5: Run project, đăng nhập user: qly1, password: 123456 để chạy chương trình.


## NẾU CÓ LỖI KHI CHẠY THỬ CHƯƠNG TRÌNH
### LIÊN HỆ: `21522258@gm.uit.edu.vn` để được hỗ trợ (tuỳ vào lỗi, có thể có lỗi không hỗ trợ được, mong mọi người thông cảm)



