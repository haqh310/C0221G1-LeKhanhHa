package model.service;

import model.bean.DanhMuc;
import model.bean.SanPham;
import model.repository.ProductRepository;

import java.util.List;

public class ProductService implements IService<SanPham> {
    ProductRepository productRepository =  new ProductRepository();
    @Override
    public List<SanPham> findAll() {
        return productRepository.selectAll();
    }

    @Override
    public SanPham findById(int id) {
        return productRepository.selectById(id);
    }

    @Override
    public List<SanPham> findByName(String name) {
        return productRepository.selectByName(name);
    }

    @Override
    public boolean insert(SanPham sanPham) {
        return productRepository.insert(sanPham);
    }

    @Override
    public boolean update(SanPham sanPham) {
        return productRepository.update(sanPham);
    }

    @Override
    public boolean remove(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<DanhMuc> lisDanhMuc() {
        return productRepository.selectDanhMuc();
    }
}
