USE [QuanLyKhachSan]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[MaChiTietDichVu] [nvarchar](10) NOT NULL,
	[MaHoaDonChiTiet] [nvarchar](10) NOT NULL,
	[MaDichVu] [nvarchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietDichVu] PRIMARY KEY CLUSTERED 
(
	[MaChiTietDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 12/9/2021 12:32:13 PM ******/
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
/****** Object:  Table [dbo].[GiaTriKhac]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaTriKhac](
	[MaGiaTri] [nvarchar](10) NOT NULL,
	[ThoiGianCheckIn] [time](7) NULL,
	[ThoiGianCheckOut] [nchar](10) NULL,
	[GiaTriCheckIn] [int] NULL,
	[GiaTriCheckOut] [int] NULL,
	[Mota] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[MaHinhThucThanhToan] [nvarchar](10) NOT NULL,
	[TenHinhThucThanhToan] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HinhThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[MaHinhThucThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [nvarchar](10) NOT NULL,
	[MaKhachHang] [nvarchar](10) NOT NULL,
	[SoNguoi] [int] NULL,
	[MaNhanVien] [nvarchar](10) NOT NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHoaDonChiTiet] [nvarchar](10) NOT NULL,
	[MaPhong] [nvarchar](10) NOT NULL,
	[MaHoaDon] [nvarchar](10) NOT NULL,
	[MaLoaiHinhThue] [nvarchar](10) NOT NULL,
	[NgayThue] [datetime] NULL,
	[TienDatCoc] [int] NOT NULL,
	[NgayDuKienTra] [datetime] NULL,
	[MaHinhThucThanhToan] [nvarchar](10) NULL,
	[PhuThuCheckIn] [int] NULL,
	[PhuThuCheckOut] [int] NULL,
	[TongTienPhong] [int] NULL,
	[TongTienDichVu] [int] NULL,
	[TienTheNganHang] [int] NULL,
	[TienKhachDua] [int] NULL,
	[TienTraLai] [int] NULL,
	[NgayTraPhong] [datetime] NULL,
	[NgayThanhToan] [datetime] NULL,
	[TrangThai] [int] NOT NULL,
	[GhiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDonChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [nvarchar](10) NOT NULL,
	[TenKhachHang] [nvarchar](50) NOT NULL,
	[Tuoi] [int] NULL,
	[GioiTinh] [bit] NOT NULL,
	[SoDienThoai] [nvarchar](10) NULL,
	[SoCCCD] [nvarchar](10) NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiDichVu]    Script Date: 12/9/2021 12:32:13 PM ******/
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
/****** Object:  Table [dbo].[LoaiHinhThue]    Script Date: 12/9/2021 12:32:13 PM ******/
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
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 12/9/2021 12:32:13 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [nvarchar](10) NOT NULL,
	[TenNhanVien] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[MaQuyen] [nvarchar](10) NULL,
	[Email] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](10) NOT NULL,
	[MaLoaiPhong] [nvarchar](10) NOT NULL,
	[MaTang] [nvarchar](10) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 12/9/2021 12:32:13 PM ******/
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
/****** Object:  Table [dbo].[Tang]    Script Date: 12/9/2021 12:32:13 PM ******/
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
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV01', N'HDCT1', N'01', 26)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV02', N'HDCT1', N'06', 3)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV03', N'HDCT2', N'01', 7)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV04', N'HDCT6', N'01', 24)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV05', N'HDCT8', N'01', 4)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV06', N'HDCT8', N'02', 2000)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV07', N'HDCT6', N'02', 3)
INSERT [dbo].[ChiTietDichVu] ([MaChiTietDichVu], [MaHoaDonChiTiet], [MaDichVu], [SoLuong]) VALUES (N'CTDV08', N'HDCT15', N'01', 3)
GO
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'01', N'02', N'Cơm Sờn Hú Hí', 10000, N'Helo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'02', N'01', N'Cơm Tấm', 20000, N'Helo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'03', N'01', N'Cơm Nguội', 30000, N'Helo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'04', N'02', N'Bia', 10000, N'Lo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'05', N'02', N'Nước Suối', 5000, N'Milo')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'06', N'02', N'Coca', 8000, N'Hele')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'07', N'01', N'Cơm Xá Xíu', 10000, N'Cc')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'08', N'01', N'Cơm Thịt Bằm', 10000, N'Hihi')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'09', N'01', N'Cơm Trộn', 9000, N'Haha')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'10', N'01', N'Cơm BBQ', 1000, N'Hahaha')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'11', N'01', N'Cơm Rau Muống', 9999, N'LeuLeu')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'GH01', N'DV01', N'Gọi Hoa Víp Tặng Em Ngừi Iu', 10000000, N'Há há há há')
INSERT [dbo].[DichVu] ([MaDichVu], [MaLoaiDichVu], [TenDichVu], [DonGia], [GhiChu]) VALUES (N'zccz', N'03', N'zcxcz', 12, N'13312')
GO
INSERT [dbo].[GiaTriKhac] ([MaGiaTri], [ThoiGianCheckIn], [ThoiGianCheckOut], [GiaTriCheckIn], [GiaTriCheckOut], [Mota]) VALUES (N'CheckTG', CAST(N'09:00:00' AS Time), N'12:00:00  ', 30, 30, N'Thời Gian CheckIn CheckOut')
GO
INSERT [dbo].[HinhThucThanhToan] ([MaHinhThucThanhToan], [TenHinhThucThanhToan]) VALUES (N'01', N'Tiền Mặt')
INSERT [dbo].[HinhThucThanhToan] ([MaHinhThucThanhToan], [TenHinhThucThanhToan]) VALUES (N'02', N'Thẻ Ngân Hàng')
GO
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD1', N'KH001', 2, N'NV001', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD2', N'KH002', 1, N'NV001', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD3', N'KH002', 2, N'NV001', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD4', N'KH001', 3, N'NV001', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD5', N'KH1', 1, N'NV001', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD6', N'KH2', 1, N'NV001', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [MaKhachHang], [SoNguoi], [MaNhanVien], [TrangThai]) VALUES (N'HD7', N'KH3', 1, N'NV001', 0)
GO
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT1', N'100', N'HD1', N'01', CAST(N'2021-12-06T12:45:25.840' AS DateTime), 150000, CAST(N'2021-12-07T12:45:25.843' AS DateTime), N'02', 0, 0, 1000, 284000, 79445, 205555, 0, CAST(N'2021-12-06T13:31:28.353' AS DateTime), CAST(N'2021-12-06T13:31:28.353' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT10', N'105', N'HD3', N'01', CAST(N'2021-12-02T00:00:00.000' AS DateTime), 14444, CAST(N'2021-12-04T00:00:00.000' AS DateTime), N'01', 0, 0, 12143124, 14414, 142412, 124124, 124124, CAST(N'2021-12-04T00:00:00.000' AS DateTime), CAST(N'2021-12-04T00:00:00.000' AS DateTime), 3, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT11', N'106', N'HD4', N'01', CAST(N'2021-11-02T00:00:00.000' AS DateTime), 12412, CAST(N'2021-11-04T00:00:00.000' AS DateTime), N'01', 0, 0, 90124901, 12412412, 12412414, 12412414, 14121, CAST(N'2021-11-04T00:00:00.000' AS DateTime), CAST(N'2021-11-04T00:00:00.000' AS DateTime), 3, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT12', N'104', N'HD3', N'01', CAST(N'2021-12-09T10:22:37.000' AS DateTime), 123456, CAST(N'2021-12-10T10:22:37.000' AS DateTime), NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, 1, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT13', N'103', N'HD5', N'01', CAST(N'2021-12-09T10:25:45.513' AS DateTime), 211, CAST(N'2021-12-10T10:25:45.513' AS DateTime), NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, 1, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT14', N'111', N'HD6', N'01', CAST(N'2021-12-09T10:47:00.587' AS DateTime), 0, CAST(N'2021-12-09T10:47:00.590' AS DateTime), NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, 1, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT15', N'109', N'HD7', N'01', CAST(N'2021-12-09T12:09:56.360' AS DateTime), 1500, CAST(N'2021-12-09T12:09:56.363' AS DateTime), N'02', 0, 0, 125, 30000, 29425, 2000, 0, CAST(N'2021-12-09T12:10:24.000' AS DateTime), CAST(N'2021-12-09T12:10:24.497' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT16', N'109', N'HD7', N'02', CAST(N'2021-12-09T12:10:24.000' AS DateTime), 0, CAST(N'2021-12-09T12:11:46.100' AS DateTime), N'02', 0, 300, 1000, 0, 0, 0, 0, CAST(N'2021-12-09T12:10:24.497' AS DateTime), CAST(N'2021-12-09T12:10:24.497' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT2', N'101', N'HD2', N'02', CAST(N'2021-12-06T13:39:00.747' AS DateTime), 111111, CAST(N'2021-12-06T13:39:00.747' AS DateTime), N'01', 0, 60, 200, 70000, 0, 166666, 94956, CAST(N'2021-12-06T13:39:00.747' AS DateTime), CAST(N'2021-12-06T15:07:26.623' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT3', N'101', N'HD2', N'01', CAST(N'2021-12-06T13:39:00.747' AS DateTime), 0, CAST(N'2021-12-07T13:40:16.410' AS DateTime), N'01', 0, 0, 1000, 0, 0, 0, 0, CAST(N'2021-12-06T14:25:02.000' AS DateTime), CAST(N'2021-12-06T15:07:26.623' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT4', N'101', N'HD2', N'02', CAST(N'2021-12-06T14:25:02.000' AS DateTime), 0, CAST(N'2021-12-08T14:25:32.617' AS DateTime), N'01', 0, 0, 200, 0, 0, 0, 0, CAST(N'2021-12-06T15:01:23.000' AS DateTime), CAST(N'2021-12-06T15:07:26.623' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT5', N'101', N'HD2', N'01', CAST(N'2021-12-06T15:01:23.000' AS DateTime), 0, CAST(N'2021-12-07T15:01:31.377' AS DateTime), N'01', 0, 0, 250, 0, 0, 0, 0, CAST(N'2021-12-06T15:07:26.623' AS DateTime), CAST(N'2021-12-06T15:07:26.623' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT6', N'101', N'HD3', N'01', CAST(N'2021-12-06T15:08:48.657' AS DateTime), 22222, CAST(N'2021-12-07T15:08:48.660' AS DateTime), NULL, 0, 0, 0, 0, 0, 0, 0, CAST(N'2021-12-06T15:10:39.000' AS DateTime), NULL, 2, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT7', N'101', N'HD3', N'02', CAST(N'2021-12-06T15:10:39.000' AS DateTime), 0, CAST(N'2021-12-08T15:10:42.940' AS DateTime), NULL, 0, 0, 0, 0, 0, 0, 0, NULL, NULL, 1, NULL)
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT8', N'102', N'HD4', N'01', CAST(N'2021-12-06T22:34:30.123' AS DateTime), 150000, CAST(N'2021-12-06T22:34:30.133' AS DateTime), N'01', 0, 0, 12, 40040000, 0, 100150000, 60109988, CAST(N'2021-12-06T22:34:41.873' AS DateTime), CAST(N'2021-12-06T22:34:41.873' AS DateTime), 3, N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDonChiTiet], [MaPhong], [MaHoaDon], [MaLoaiHinhThue], [NgayThue], [TienDatCoc], [NgayDuKienTra], [MaHinhThucThanhToan], [PhuThuCheckIn], [PhuThuCheckOut], [TongTienPhong], [TongTienDichVu], [TienTheNganHang], [TienKhachDua], [TienTraLai], [NgayTraPhong], [NgayThanhToan], [TrangThai], [GhiChu]) VALUES (N'HDCT9', N'103', N'HD4', N'01', CAST(N'2021-12-06T12:00:00.000' AS DateTime), 15000, CAST(N'2021-12-08T12:00:00.000' AS DateTime), N'01', 60, 60, 1000000, 200000, 100000, 122124, 11414, CAST(N'2021-12-08T12:00:00.000' AS DateTime), CAST(N'2021-12-08T12:00:00.000' AS DateTime), 3, NULL)
GO
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH001', N'Quang Vũ', 18, 1, N'0981861798', N'099999999', N'Khách Vip')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH002', N'Khá Bảnh', 22, 1, N'0987654321', N'000000000', N'Cực Víp')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH003', N'Ha lo ha lo', 21, 1, N'1111111111', N'1111111111', N'Hahah')
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH1', N'Thùy Linh', 18, 1, N'0000000000', N'0000000000', NULL)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH2', N'Thùy Trang', 18, 1, N'', N'', NULL)
INSERT [dbo].[KhachHang] ([MaKhachHang], [TenKhachHang], [Tuoi], [GioiTinh], [SoDienThoai], [SoCCCD], [GhiChu]) VALUES (N'KH3', N'Thùy Linh', 12, 1, N'', N'', NULL)
GO
INSERT [dbo].[LoaiDichVu] ([MaLoaiDichVu], [TenLoaiDichVu], [GhiChu]) VALUES (N'01', N'Cơm', N'NoNo')
INSERT [dbo].[LoaiDichVu] ([MaLoaiDichVu], [TenLoaiDichVu], [GhiChu]) VALUES (N'02', N'Nước Uống', N'KhatKhat')
INSERT [dbo].[LoaiDichVu] ([MaLoaiDichVu], [TenLoaiDichVu], [GhiChu]) VALUES (N'03', N'Bia', N'Hahah')
INSERT [dbo].[LoaiDichVu] ([MaLoaiDichVu], [TenLoaiDichVu], [GhiChu]) VALUES (N'DV01', N'Gọi Hoa', N'He hehe ehhehe')
GO
INSERT [dbo].[LoaiHinhThue] ([MaLoaiHinhThue], [TenLoaiHinhThue]) VALUES (N'01', N'Theo Giờ')
INSERT [dbo].[LoaiHinhThue] ([MaLoaiHinhThue], [TenLoaiHinhThue]) VALUES (N'02', N'Theo Ngày')
GO
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'1', N'Vip', 1000, 200)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'2', N'Thường', 50, 100)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'3', N'Hoàng Đế', 6000, 5555)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'4', N'Tổng Thống', 5555, 4444)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'5', N'Đôi', 500, 1000)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [GiaTheoGio], [GiaTheoNgay]) VALUES (N'LP01', N'Sờ Tu Đi Ô', 100000, 2000000)
GO
INSERT [dbo].[NhanVien] ([MaNhanVien], [TenNhanVien], [MatKhau], [MaQuyen], [Email], [GhiChu]) VALUES (N'NV001', N'Quang Vũ', N'1234', N'01', N'vudz@gmail.com', N'hahahah')
GO
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'100', N'1', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'101', N'1', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'102', N'3', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'103', N'2', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'104', N'3', N'1', N'Hehe', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'105', N'2', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'106', N'2', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'107', N'1', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'108', N'2', N'1', N'LiuLiu', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'109', N'5', N'1', N'HeHe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'110', N'1', N'1', N'Hehe', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'111', N'1', N'1', N'Hihi', 2)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'112', N'1', N'1', N'Hihi', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'113', N'3', N'1', N'Há há', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'114', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'115', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'116', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'117', N'1', N'1', N'Hế hế', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'118', N'1', N'1', N'hí hí', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'120', N'1', N'1', N'ff', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'121', N'1', N'1', N'1', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'122', N'1', N'1', N'1', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'123', N'1', N'1', N'1', 3)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'124', N'1', N'1', N'1', 3)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'125', N'1', N'1', N'1', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'126', N'1', N'1', N'1', 3)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'127', N'1', N'1', N'1', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'128', N'1', N'1', N'1', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'200', N'1', N'2', N'Hi shis', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'201', N'1', N'2', N'hggh', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'301', N'3', N'3', N'gg', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A101', N'1', N'1', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A201', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A202', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A401', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A402', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A403', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A404', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A405', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A406', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A407', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A408', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A409', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A410', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A411', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A412', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A413', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A414', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A415', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A416', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A417', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A418', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A419', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A420', N'2', N'4', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A601', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A602', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A603', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A604', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A605', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A606', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A607', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A608', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A609', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A610', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A6100', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A611', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A612', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A613', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A614', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A615', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A616', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A617', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A618', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A619', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A620', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A621', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A622', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A623', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A624', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A625', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A626', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A627', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A628', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A629', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A630', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A631', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A632', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A633', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A634', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A635', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A636', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A637', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A638', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A639', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A640', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A641', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A642', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A643', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A644', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A645', N'2', N'6', N'', 1)
GO
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A646', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A647', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A648', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A649', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A650', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A651', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A652', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A653', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A654', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A655', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A656', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A657', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A658', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A659', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A660', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A661', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A662', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A663', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A664', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A665', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A666', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A667', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A668', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A669', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A670', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A671', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A672', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A673', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A674', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A675', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A676', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A677', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A678', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A679', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A680', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A681', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A682', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A683', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A684', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A685', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A686', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A687', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A688', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A689', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A690', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A691', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A692', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A693', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A694', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A695', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A696', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A697', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A698', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'A699', N'2', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B501', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B502', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B503', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B504', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B505', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B506', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B507', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B508', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B509', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B510', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B511', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B512', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B513', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B514', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B515', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B516', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B517', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B518', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B519', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B520', N'3', N'5', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B701', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B702', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B703', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B704', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B705', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B706', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B707', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B708', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B709', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B710', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B711', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B712', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B713', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B714', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B715', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B716', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B717', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B718', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B719', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B720', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B721', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B722', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B723', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B724', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B725', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B726', N'1', N'7', N'', 1)
GO
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B727', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B728', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B729', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B730', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B731', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B732', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B733', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B734', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B735', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B736', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B737', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B738', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B739', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B740', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B741', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B742', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B743', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B744', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B745', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B746', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B747', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B748', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B749', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B750', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'B751', N'1', N'7', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D201', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D202', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D203', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D204', N'4', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D205', N'4', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D206', N'4', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D207', N'4', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D208', N'4', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D209', N'4', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D210', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D211', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D212', N'1', N'2', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D601', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D602', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D603', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D604', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D605', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D606', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D607', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D608', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D609', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D610', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D611', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D612', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D613', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D614', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D615', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D616', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D617', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D618', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D619', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D620', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D621', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D622', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D623', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D624', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D625', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D626', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D627', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D628', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D629', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D630', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D631', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D632', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D633', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D634', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D635', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D636', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D637', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D638', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D639', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D640', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D641', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D642', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D643', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D644', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D645', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D646', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D647', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D648', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D649', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D650', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D651', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D652', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D653', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D654', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D655', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D656', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D657', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D658', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D659', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D660', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D661', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D662', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D663', N'4', N'6', N'', 1)
GO
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D664', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D665', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D666', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D667', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D668', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D669', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D670', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D671', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D672', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D673', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D674', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D675', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D676', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D677', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D678', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D679', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D680', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D681', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D682', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D683', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D684', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D685', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D686', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D687', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D688', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D689', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D690', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D691', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D692', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D693', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D694', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D695', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D696', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D697', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D698', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'D699', N'4', N'6', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G301', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G302', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G303', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G304', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G305', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G306', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G307', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G308', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G309', N'2', N'3', N'', 1)
INSERT [dbo].[Phong] ([MaPhong], [MaLoaiPhong], [MaTang], [GhiChu], [TrangThai]) VALUES (N'G310', N'2', N'3', N'', 1)
GO
INSERT [dbo].[Quyen] ([MaQuyen], [TenQuyen]) VALUES (N'01', N'Quản Lý')
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
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'21', 21)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'22', 22)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'23', 23)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'24', 24)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'25', 25)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'26', 26)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'3', 3)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'4', 4)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'5', 5)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'6', 6)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'7', 7)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'8', 8)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'9', 9)
INSERT [dbo].[Tang] ([MaTang], [SoTang]) VALUES (N'M27', 27)
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
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HinhThucThanhToan] FOREIGN KEY([MaHinhThucThanhToan])
REFERENCES [dbo].[HinhThucThanhToan] ([MaHinhThucThanhToan])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HinhThucThanhToan]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_LoaiHinhThue] FOREIGN KEY([MaLoaiHinhThue])
REFERENCES [dbo].[LoaiHinhThue] ([MaLoaiHinhThue])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_LoaiHinhThue]
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
/****** Object:  StoredProcedure [dbo].[sp_ChiTietDichVuAuto]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_ChiTietDichVuAuto]
as
begin
declare @ma_next varchar(20)
declare @max int
select @max = COUNT(MaChiTietDichVu) + 1 from ChiTietDichVu where MaChiTietDichVu like 'CTDV'
set @ma_next = 'CTDV' + RIGHT('0' + CAST(@max as varchar(18)),18)
while(exists(select MaChiTietDichVu from ChiTietDichVu where MaChiTietDichVu = @ma_next))
begin 
	set @max = @max +1
	set @ma_next = 'CTDV' + RIGHT('0' + CAST(@max as varchar(18)),18)
end
select @ma_next ChiTietDichVuAuto
end
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThuTheoKhoangNgay]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_DoanhThuTheoKhoangNgay](@NgayBatDau Date, @NgayKetThuc Date)
AS BEGIN
select COUNT(MaHoaDonChiTiet) SoLuongHoaDonThanhToan, SUM(TongTienPhong) TongTienPhong, AVG(TongTienPhong) TrungBinhTienPhong, sum(TongTienDichVu) TongTienDichVu, AVG(TongTienDichVu) TrungBinhTienDichVu, SUM(PhuThuCheckIn + PhuThuCheckOut) PhuThu, SUM(TongTienDichVu + TongTienPhong + PhuThuCheckIn + PhuThuCheckOut) TongTien, MIN(TongTienDichVu + TongTienPhong) HoaDonThapNhat, MAX(TongTienDichVu + TongTienPhong) HoaDonCaoNhat, CONVERT(date,NgayThanhToan) NgayThanhToan
from HoaDonChiTiet where TrangThai = 3 And CONVERT(date,NgayThanhToan) >= @NgayBatDau and CONVERT(date,NgayThanhToan) <= @NgayKetThuc
group by CONVERT(date,NgayThanhToan) Order by CONVERT(date,NgayThanhToan) Desc
END
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThuTheoNam]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_DoanhThuTheoNam]
AS BEGIN
select COUNT(MaHoaDonChiTiet) SoLuongHoaDonThanhToan, SUM(TongTienPhong) TongTienPhong, AVG(TongTienPhong) TrungBinhTienPhong, sum(TongTienDichVu) TongTienDichVu, AVG(TongTienDichVu) TrungBinhTienDichVu, SUM(PhuThuCheckIn + PhuThuCheckOut) PhuThu, SUM(TongTienDichVu + TongTienPhong + PhuThuCheckIn + PhuThuCheckOut) TongTien, MIN(TongTienDichVu + TongTienPhong) HoaDonThapNhat, MAX(TongTienDichVu + TongTienPhong) HoaDonCaoNhat, YEAR(NgayThanhToan) ThoiGianThanhToan
from HoaDonChiTiet where TrangThai = 3 
group by YEAR(NgayThanhToan) Order by YEAR(NgayThanhToan) Desc
END
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThuTheoNgay]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_DoanhThuTheoNgay](@Ngay Date)
AS BEGIN
select COUNT(MaHoaDonChiTiet) SoLuongHoaDonThanhToan, SUM(TongTienPhong) TongTienPhong, AVG(TongTienPhong) TrungBinhTienPhong, sum(TongTienDichVu) TongTienDichVu, AVG(TongTienDichVu) TrungBinhTienDichVu, SUM(PhuThuCheckIn + PhuThuCheckOut) PhuThu, SUM(TongTienDichVu + TongTienPhong + PhuThuCheckIn + PhuThuCheckOut) TongTien, MIN(TongTienDichVu + TongTienPhong) HoaDonThapNhat, MAX(TongTienDichVu + TongTienPhong) HoaDonCaoNhat, CONVERT(date,NgayThanhToan) NgayThanhToan
from HoaDonChiTiet where TrangThai = 3 And CONVERT(date,NgayThanhToan) = @Ngay
group by CONVERT(date,NgayThanhToan) Order by CONVERT(date,NgayThanhToan) Desc
END
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThuTheoThang]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_DoanhThuTheoThang](@Nam varchar(10))
AS BEGIN
select COUNT(MaHoaDonChiTiet) SoLuongHoaDonThanhToan, SUM(TongTienPhong) TongTienPhong, AVG(TongTienPhong) TrungBinhTienPhong, sum(TongTienDichVu) TongTienDichVu, AVG(TongTienDichVu) TrungBinhTienDichVu, SUM(PhuThuCheckIn + PhuThuCheckOut) PhuThu, SUM(TongTienDichVu + TongTienPhong + PhuThuCheckIn + PhuThuCheckOut) TongTien, MIN(TongTienDichVu + TongTienPhong) HoaDonThapNhat, MAX(TongTienDichVu + TongTienPhong) HoaDonCaoNhat, CONCAT(MONTH(NgayThanhToan),'-',YEAR(NgayThanhToan)) ThoiGianThanhToan
from HoaDonChiTiet where TrangThai = 3 and YEAR(NgayThanhToan) = @Nam
group by CONCAT(MONTH(NgayThanhToan),'-',YEAR(NgayThanhToan)) Order by CONCAT(MONTH(NgayThanhToan),'-',YEAR(NgayThanhToan)) Desc
END
GO
/****** Object:  StoredProcedure [dbo].[sp_DoanhThuTong]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_DoanhThuTong]
AS BEGIN
select COUNT(MaHoaDonChiTiet) SoLuongHoaDonThanhToan, SUM(TongTienPhong) TongTienPhong, AVG(TongTienPhong) TrungBinhTienPhong, sum(TongTienDichVu) TongTienDichVu, AVG(TongTienDichVu) TrungBinhTienDichVu, SUM(PhuThuCheckIn + PhuThuCheckOut) PhuThu, SUM(TongTienDichVu + TongTienPhong + PhuThuCheckIn + PhuThuCheckOut) TongTien, MIN(TongTienDichVu + TongTienPhong) HoaDonThapNhat, MAX(TongTienDichVu + TongTienPhong) HoaDonCaoNhat, CONVERT(date,NgayThanhToan) NgayThanhToan
from HoaDonChiTiet where TrangThai = 3 
group by CONVERT(date,NgayThanhToan) Order by CONVERT(date,NgayThanhToan) Desc
END
GO
/****** Object:  StoredProcedure [dbo].[sp_HoaDonAuto]    Script Date: 12/9/2021 12:32:13 PM ******/
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
set @ma_next = 'HD' + RIGHT(CAST(@max as varchar(18)),18)
while(exists(select MaHoaDon from HoaDon where MaHoaDon = @ma_next))
begin 
	set @max = @max +1
	set @ma_next = 'HD' + RIGHT(CAST(@max as varchar(18)),18)
end
select @ma_next as HoaDonAuto
end
GO
/****** Object:  StoredProcedure [dbo].[sp_HoaDonChiTietAuto]    Script Date: 12/9/2021 12:32:13 PM ******/
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
set @ma_next = 'HDCT' + RIGHT(CAST(@max as varchar(18)),18)
while(exists(select MaHoaDonChiTiet from HoaDonChiTiet where MaHoaDonChiTiet = @ma_next))
begin 
	set @max = @max +1
	set @ma_next = 'HDCT' + RIGHT(CAST(@max as varchar(18)),18)
end
select @ma_next HoaDonChiTietAuto
end
GO
/****** Object:  StoredProcedure [dbo].[sp_MaKHAuto]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_MaKHAuto]
as
begin
declare @ma_next varchar(20)
declare @max int
select @max = COUNT(MaKhachHang) + 1 from KhachHang where MaKhachHang like 'KH'
set @ma_next = 'KH' + RIGHT(CAST(@max as varchar(18)),18)
while(exists(select MaKhachHang from KhachHang where MaKhachHang = @ma_next))
begin 
	set @max = @max +1
	set @ma_next = 'KH' + RIGHT(CAST(@max as varchar(18)),18)
end
select @ma_next MaKhachHang
end
GO
/****** Object:  StoredProcedure [dbo].[sp_MaPhong]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_MaPhong](@KyHieu nvarchar(10))
as
begin
	declare @ma_next varchar(20)
	declare @max int
	select @max = COUNT(MaPhong) + 1 from Phong where MaPhong like @KyHieu+'%'
	set @ma_next = @KyHieu + RIGHT(CAST(@max as varchar(18)),18)
	If(@max < 10)
	begin
		set @ma_next = @KyHieu + RIGHT('0' + CAST(@max as varchar(18)),18)
		while(exists(select MaPhong from Phong where MaPhong = @ma_next))
		begin 
			set @max = @max +1
			set @ma_next = @KyHieu + RIGHT('0' + CAST(@max as varchar(18)),18)
			if(@max < 10)
			begin
				set @ma_next = @KyHieu + RIGHT(CAST(@max as varchar(18)),18)
			end
		end
	end
	select @ma_next MaPhong
end
GO
/****** Object:  StoredProcedure [dbo].[sp_TKDichVu]    Script Date: 12/9/2021 12:32:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_TKDichVu]
AS BEGIN
select TenDichVu, TenLoaiDichVu, Sum(SoLuong) SoLuong, Sum(SoLuong * DonGia) TongTien
from ChiTietDichVu
join HoaDonChiTiet on HoaDonChiTiet.MaHoaDonChiTiet = ChiTietDichVu.MaHoaDonChiTiet
join DichVu on DichVu.MaDichVu = ChiTietDichVu.MaDichVu
join LoaiDichVu on LoaiDichVu.MaLoaiDichVu = DichVu.MaLoaiDichVu
where TrangThai = 3
group by TenDichVu,TenLoaiDichVu
END
GO
