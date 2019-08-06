package com.phihung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("api/")
@SessionAttributes("giohangList")
public class APIController {

/*
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ServletContext context;

    @GetMapping("KiemTraDangNhap")
    public String  KiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau){
        boolean kiemtra = nhanVienService.KiemTraDangNhap(email,matkhau);
        return  "dangnhap2";
    }

    @GetMapping("ThemGioHang")
    @ResponseBody
    public String  ThemGioHang(@RequestParam int masp, @RequestParam String tensp,@RequestParam int mamau, @RequestParam String tenmau,@RequestParam int masize ,@RequestParam String tensize,@RequestParam String giatien,@RequestParam int soluong,@RequestParam int machitietsanpham, HttpSession httpSession)
    {
        List<GioHang> gioHangList = new ArrayList<GioHang>();

        //Nếu session chưa tồn tại -> Thêm mới
        if( null == httpSession.getAttribute("giohangList")) {
            GioHang objGioHang = new GioHang(masp, masize, mamau, tensp, giatien, tenmau, tensize, 1,machitietsanpham);
            gioHangList.add(objGioHang);
            httpSession.setAttribute("giohangList", gioHangList);

           return gioHangList.size()+"";

        }
        //Nếu nhấn thêm một sản phẩm 2 lần ( tức là mua với số lượng là 2)
        else
        {
            gioHangList = (List<GioHang>)httpSession.getAttribute("giohangList");
            int vitrisanpham = KiemTraSanPhamTonTai(gioHangList,httpSession, masp, masize,mamau);
            if(vitrisanpham == -1)
            {
                GioHang objGioHang = new GioHang(masp, masize,mamau,tensp,giatien,tenmau,tensize,1,machitietsanpham);
                gioHangList.add(objGioHang);
            }
            else
            {
                int soluongcu = gioHangList.get(vitrisanpham).getSoluong();
                gioHangList.get(vitrisanpham).setSoluong(soluongcu + 1);
            }
            return gioHangList.size()+"";
        }
    }

    //Kiểm tra sản phẩm tồn tại trong giỏ hàng
    private int KiemTraSanPhamTonTai(List<GioHang> gioHangList,HttpSession httpSession ,int masp, int masize, int mamau)
    {
        for(int i = 0;i<gioHangList.size();i++)
        {
            if(gioHangList.get(i).getMasp() == masp && gioHangList.get(i).getMasize() == masize && gioHangList.get(i).getMamau() == mamau)
                return i;
        }
        return -1;
    }

    @GetMapping("LaySoLuongGioHang")
    @ResponseBody
    public String LaySoLuongGioHang(HttpSession httpSession)
    {
        if( null == httpSession.getAttribute("giohangList")) {
            List<GioHang> gioHangList = (List<GioHang>) httpSession.getAttribute("giohangList");
            return gioHangList.size()+"";
        }
        return null;
    }

    @GetMapping("CapNhatGioHang")
    @ResponseBody
    public void CapNhatGioHang(HttpSession httpSession, @RequestParam int soluong, @RequestParam int masp, @RequestParam int mamau, @RequestParam int masize){
        if(null != httpSession.getAttribute("giohangList"))
        {
            List<GioHang> listGioHang = (List<GioHang>)httpSession.getAttribute("giohangList");
            int vitrisanpham = KiemTraSanPhamTonTai(listGioHang,httpSession, masp, masize,mamau);
            listGioHang.get(vitrisanpham).setSoluong(soluong);
      }
    }

    @GetMapping("XoaGioHang")
    @ResponseBody
    public void XoaGioHang(HttpSession httpSession, @RequestParam int masp, @RequestParam int mamau, @RequestParam int masize){
        if(null != httpSession.getAttribute("giohangList")) {
            List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohangList");
            int vitrisanpham = KiemTraSanPhamTonTai(listGioHang, httpSession, masp, masize, mamau);
            listGioHang.remove(vitrisanpham);
        }

    }

    @GetMapping("XoaSanPham")
    public void XoaSanPham(@RequestParam int masanpham)
    {
        sanPhamService.XoaSanPham(masanpham);
    }

    @PostMapping("UploadFile")
    @ResponseBody
    public String UploadFile(MultipartHttpServletRequest servletRequest)
    {

        String pathSaveFile = context.getRealPath("/resources/images/sanpham/");
        Iterator<String> listFileName = servletRequest.getFileNames();
        MultipartFile multipartFile = servletRequest.getFile(listFileName.next());

        File fileSave = new File(pathSaveFile + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(fileSave);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return "true";
    }



    @PostMapping("ThemSanPham")
    @ResponseBody
    public void ThemSanPham(@RequestParam String dataJson){
        System.out.println("Them san pham");
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        JsonNode jsonObject;
//        try{
//            jsonObject = objectMapper.readTree(dataJson);
//
//            SanPham sanpham = objectMapper.readValue(dataJson,SanPham.class);
//
//            DanhMucSanPham danhmucsanpham = new DanhMucSanPham();
//            danhmucsanpham.setMadanhmuc(1);
//
//            JsonNode jsonChiTiet = jsonObject.get("chitietsanpham");
//            Set<ChiTietSanPham> chiTietSanPhamSet =new HashSet<ChiTietSanPham>();
//            for(JsonNode objChiTiet : jsonChiTiet)
//            {
//                ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
//
//                MauSanPham mauSanPham = new MauSanPham();
//                mauSanPham.setMamau(objChiTiet.get("mausanpham").asInt());
//
//                Size size = new Size();
//                size.setMasize(objChiTiet.get("size").asInt());
//
//                chiTietSanPham.setMau(mauSanPham);
//                chiTietSanPham.setSize(size);
//                chiTietSanPham.setSoluong(objChiTiet.get("soluong").asInt());
//
//                chiTietSanPhamSet.add(chiTietSanPham);
//            }
//
//            String tensanpham = jsonObject.get("tensanpham").asText();
//            String giatien = jsonObject.get("giatien").asText();
//            String hinhsanpham = jsonObject.get("hinhsanpham").asText();
//
//            sanpham.setChitietsanpham(chiTietSanPhamSet);
//            sanpham.setDanhMucSanPham(danhmucsanpham);
//            sanpham.setTensanpham(tensanpham);
//            sanpham.setGiatien(giatien);
//            sanpham.setHinhsanpham(hinhsanpham);
//
//
//           sanPhamService.ThemSanPham(sanpham);
//
//        }
//        catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }

    }

    @PostMapping(path="LayDanhSachSanPhamTheoMa",produces = "application/json;charset=utf8")
    @ResponseBody
    public Json_SanPham LayDanhSachSanPhamTheoMa(@RequestParam int masanpham){

        SanPham sanPham = sanPhamService.LayChiTietSanPhamTheoMa(masanpham);

        Json_SanPham json_sanPham = new Json_SanPham();
        json_sanPham.setTensanpham(sanPham.getTensanpham());
        json_sanPham.setGiatien(sanPham.getGiatien());
        json_sanPham.setMasanpham(sanPham.getMasanpham());
        json_sanPham.setHinhsanpham(sanPham.getHinhsanpham());
        json_sanPham.setMota(sanPham.getMota());

        DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
        danhMucSanPham.setMadanhmuc(sanPham.getDanhMucSanPham().getMadanhmuc());
        danhMucSanPham.setTendanhmuc(sanPham.getDanhMucSanPham().getTendanhmuc());

        Set<ChiTietSanPham> chiTietSanPhams = new HashSet<ChiTietSanPham>();

        System.out.println(sanPham.getChitietsanpham().size());

        for(ChiTietSanPham value : sanPham.getChitietsanpham())
        {
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

            chiTietSanPham.setMachitietsanpham(value.getMachitietsanpham());

            MauSanPham mauSanPham = new MauSanPham();
            mauSanPham.setMamau(value.getMau().getMamau());
            mauSanPham.setTenmau(value.getMau().getTenmau());

            Size size = new Size();
            size.setMasize(value.getSize().getMasize());
            size.setSize(value.getSize().getSize());

            chiTietSanPham.setMau(mauSanPham);
            chiTietSanPham.setSize(size);
            chiTietSanPham.setSoluong(value.getSoluong());

            chiTietSanPhams.add(chiTietSanPham);
        }
        json_sanPham.setDanhMucSanPham(danhMucSanPham);
        json_sanPham.setChiTietSanPhamSet(chiTietSanPhams);


        return json_sanPham;

    }
*/



}
