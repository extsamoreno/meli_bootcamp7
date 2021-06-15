package com.example.demo.project.services;

import com.example.demo.project.exceptions.ProductIdNotFoundException;
import com.example.demo.project.models.Product;
import com.example.demo.project.repositories.IProductRepository;
import com.example.demo.project.dtos.ProductDTO;
import com.example.demo.project.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepository;



    @Override
    public ProductDTO getProductById(Integer id) throws ProductIdNotFoundException {
        Product product = iProductRepository.getById(id);

        if(product == null){
            throw new ProductIdNotFoundException(id);
        }

        return ProductMapper.toDTO(product);
    }

    @Override
    public boolean createProduct(ProductDTO productDto) {
        Product product = ProductMapper.toProduct(productDto);

        iProductRepository.createProduct(product);

        return true;
    }

    @Override
    public Integer getExpiration(int day, int month, int year) {
        try {
            if(validateDate(day,month,year)) {
                Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/" + year);
                Calendar a = getCalendar(birthdate);
                Calendar b = getCalendar(new Date());
                int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
                if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                                a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
                    --diff;
                }
                return diff;
            }
            return -1;
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            return -1;
        }
    }

    private boolean validateDate(int Day, int Month, int Year)
    {
        GregorianCalendar Date = new GregorianCalendar();
        Date.setLenient(false);
        Date.set(Year, Month, Day, 0, 0, 0);

        try{
            Date.getTime();
            System.out.println("Date is valid");
            return true;
        }catch (Exception e){
            System.out.println("Date is invalid please try again");
            return false;
        }
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
