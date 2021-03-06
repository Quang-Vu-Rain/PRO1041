CREATE DATABASE QLKS12
GO
USE [QLKS12]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[MaChiTietDichVu] [nvarchar](10) NOT NULL,
	[MaHoaDonChiTiet] [nvarchar](10) NOT NULL,
	[MaDichVu] [nvarchar](10) NOT NULL,
	[DonGia] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietDichVu] PRIMARY KEY CLUSTERED 
(
	[MaChiTietDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDichVu] [nvarchar](10) NOT NULL,
	[MaLoaiDichVu] [nvarchar](10) NULL,
	[TenDichVu] [nvarchar](50) NOT NULL,
	[DonGia] [int] NOT NULL,
	[GhiChu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [nvarchar](10) NOT NULL,
	[MaKhachHang] [nvarchar](10) NOT NULL,
	[MaLoaiHinhThue] [nvarchar](10) NOT NULL,
	[NgayThue] [datetime] NOT NULL,
	[NgayTraDuKien] [datetime] NOT NULL,
	[SoNguoi] [int] NOT NULL,
	[MaNhanVien] [nvarchar](10) NOT NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHoaDonChiTiet] [nvarchar](10) NOT NULL,
	[MaPhong] [nvarchar](10) NOT NULL,
	[MaHoaDon] [nvarchar](10) NOT NULL,
	[SoNgayThue] [int] NULL,
	[SoGioThue] [int] NULL,
	[NgayThanhToan] [datetime] NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDonChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [nvarchar](10) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[Tuoi] [int] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[SoDienThoai] [nvarchar](10) NOT NULL,
	[SoCCCD] [nvarchar](10) NOT NULL,
	[GhiChu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiDichVu]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiDichVu](
	[MaLoaiDichVu] [nvarchar](10) NOT NULL,
	[TenLoaiDichVu] [nvarchar](10) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiDichVu] PRIMARY KEY CLUSTERED 
(
	[MaLoaiDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiHinhThue]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiHinhThue](
	[MaLoaiHinhThue] [nvarchar](10) NOT NULL,
	[TenLoaiHinhThue] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiHinhThue] PRIMARY KEY CLUSTERED 
(
	[MaLoaiHinhThue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLoaiPhong] [nvarchar](10) NOT NULL,
	[TenLoaiPhong] [nvarchar](10) NOT NULL,
	[GiaTheoGio] [int] NOT NULL,
	[GiaTheoNgay] [int] NOT NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [nvarchar](10) NOT NULL,
	[TenNhanVien] [nvarchar](100) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[MaQuyen] [nvarchar](10) NULL,
	[Email] [nvarchar](50) NULL,
	[TienDauCaNhan] [int] NULL,
	[TongTienThe] [int] NULL,
	[TongTienMat] [int] NULL,
	[GhiChu] [nvarchar](200) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](10) NOT NULL,
	[MaLoaiPhong] [nvarchar](10) NOT NULL,
	[MaTang] [nvarchar](10) NOT NULL,
	[GhiChu] [nvarchar](50) NOT NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[MaQuyen] [nvarchar](10) NOT NULL,
	[TenQuyen] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[MaQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tang]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tang](
	[MaTang] [nvarchar](10) NOT NULL,
	[SoTang] [int] NOT NULL,
 CONSTRAINT [PK_Tang] PRIMARY KEY CLUSTERED 
(
	[MaTang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'01', N'01', N'Cơm Sờn', 10000, N'Helo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'02', N'01', N'Cơm Tấm', 20000, N'Helo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'03', N'01', N'Cơm Nguội', 30000, N'Helo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'04', N'02', N'Bia', 10000, N'Lo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'05', N'02', N'Nước Suối', 5000, N'Milo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'06', N'02', N'Coca', 8000, N'Hele')
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH001', N'Quang Vũ', 18, 1, N'0981861798', N'099999999', N'Khách Vip')
GO
INSERT [dbo].[LoaiDichVu] ([MaLoaiDichVu], [TenLoaiDichVu], [GhiChu]) VALUES (N'01', N'Cơm', N'NoNo')
INSERT [dbo].[LoaiDichVu] ([MaLoaiDichVu], [TenLoaiDichVu], [GhiChu]) VALUES (N'02', N'Nước Uống', N'KhatKhat')
GO
INSERT [dbo].[LoaiHinhThue] ([MaLoaiHinhThue], [TenLoaiHinhThue]) VALUES (N'01', N'Theo Giờ')
INSERT [dbo].[LoaiHinhThue] ([MaLoaiHinhThue], [TenLoaiHinhThue]) VALUES (N'02', N'Theo Ngày')
GO
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'1', N'Vip', 1000, 200)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'2', N'Thường', 50, 100)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'3', N'Hoàng Đế', 6000, 5555)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'4', N'Tổng Thống', 5555, 4444)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'5', N'Đôi', 500, 1000)
GO
INSERT [dbo].[NhanVien] ([MaNhanVien], [MatKhau], [MaQuyen]) VALUES (N'NV001', N'1234', N'01')
GO
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'100', N'1', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'101', N'1', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'102', N'2', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'103', N'2', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'104', N'3', N'1', N'Hehe', 3)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'105', N'2', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'106', N'2', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'107', N'1', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'108', N'2', N'1', N'LiuLiu', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'109', N'5', N'1', N'HeHe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'110', N'1', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'111', N'1', N'1', N'Hihi', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'112', N'1', N'1', N'Hihi', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'113', N'3', N'1', N'Há há', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'114', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'115', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'116', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'117', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'118', N'1', N'1', N'hí hí', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'200', N'1', N'2', N'Hi shis', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'Hehe', N'1', N'1', N'hggh', 1)
GO
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen]) VALUES (N'01', N'Trưởng Phòng')
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen]) VALUES (N'02', N'Nhân Viên')
GO
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'1', 1)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'10', 10)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'11', 11)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'12', 12)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'13', 13)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'14', 14)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'15', 15)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'16', 16)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'17', 17)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'18', 18)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'19', 19)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'2', 2)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'20', 20)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'3', 3)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'4', 4)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'5', 5)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'6', 6)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'7', 7)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'8', 8)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'9', 9)
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DichVu] FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[DichVu] ([MaDichVu])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DichVu]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_HoaDonChiTiet] FOREIGN KEY([MaHoaDonChiTiet])
REFERENCES [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet])
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_HoaDonChiTiet]
GO
ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD  CONSTRAINT [FK_DichVu_LoaiDichVu] FOREIGN KEY([MaLoaiDichVu])
REFERENCES [dbo].[LoaiDichVu] ([MaLoaiDichVu])
GO
ALTER TABLE [dbo].[DichVu] CHECK CONSTRAINT [FK_DichVu_LoaiDichVu]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_LoaiHinhThue] FOREIGN KEY([MaLoaiHinhThue])
REFERENCES [dbo].[LoaiHinhThue] ([MaLoaiHinhThue])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_LoaiHinhThue]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_ChiTietHoaDon_Phong]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Quyen] FOREIGN KEY([MaQuyen])
REFERENCES [dbo].[Quyen] ([MaQuyen])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Quyen]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([MaLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([MaLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_Tang] FOREIGN KEY([MaTang])
REFERENCES [dbo].[Tang] ([MaTang])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_Tang]
GO
/****** Object:  StoredProcedure [dbo].[sp_HoaDonAuto]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_HoaDonAuto]
as
begin
declare @ma_next varchar(20)
declare @max int
select @max = COUNT(MaHoaDon) + 1 from HoaDon where MaHoaDon like 'HD'
set @ma_next = 'HD' + RIGHT('0' + CAST(@max as varchar(18)),18)
while(exists(select MaHoaDon from HoaDon where MaHoaDon = @ma_next))
begin 
	set @max = @max +1
	set @ma_next = 'HD' + RIGHT('0' + CAST(@max as varchar(18)),18)
end
select @ma_next as HoaDonAuto
end
GO
/****** Object:  StoredProcedure [dbo].[sp_HoaDonChiTietAuto]    Script Date: 11/16/2021 9:55:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_HoaDonChiTietAuto]
as
begin
declare @ma_next varchar(20)
declare @max int
select @max = COUNT(MaHoaDonChiTiet) + 1 from HoaDonChiTiet where MaHoaDonChiTiet like 'HDCT'
set @ma_next = 'HDCT' + RIGHT('0' + CAST(@max as varchar(18)),18)
while(exists(select MaHoaDonChiTiet from HoaDonChiTiet where MaHoaDonChiTiet = @ma_next))
begin 
	set @max = @max +1
	set @ma_next = 'HDCT' + RIGHT('0' + CAST(@max as varchar(18)),18)
end
select @ma_next HoaDonChiTietAuto
end
GO



SELECT MaDichVu,TenLoaiDichVu,TenDichVu,DonGia,DichVu.GhiChu FROM LoaiDichVu join DichVu on LoaiDichVu.MaLoaiDichVu = DichVu.MaLoaiDichVu
SELECT MaNhanVien,MatKhau,TenQuyen FROM Quyen join NhanVien ON Quyen.MaQuyen = NhanVien.MaQuyen

select *from NhanVien
select *from Quyen
select *from DichVu
select *from LoaiDichVu
-- test
