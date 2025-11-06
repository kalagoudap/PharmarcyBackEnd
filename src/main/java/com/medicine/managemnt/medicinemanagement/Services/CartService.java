package com.medicine.managemnt.medicinemanagement.Services;

import com.medicine.managemnt.medicinemanagement.IServices.ICartService;
import com.medicine.managemnt.medicinemanagement.Model.Cart;
import com.medicine.managemnt.medicinemanagement.Repository.CartRepo;
import com.medicine.managemnt.medicinemanagement.dtos.Cartdto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class CartService implements ICartService {
    @Autowired
    public CartRepo cartRepo;

    public Cart additemtoCart(Cartdto cartdto){
        Cart cart = new Cart();
        cart.setProductId(cartdto.getProductId() != null ? cartdto.getProductId() :0);
        cart.setCustomerId(cartdto.getCustomerId() != null ? cartdto.getCustomerId() : 0);
        cart.setTotal_price(cartdto.getPrice() != 0 ? cartdto.getPrice()* cartdto.getQuantity() : 0);
        cart.setQuantity(cartdto.getQuantity() != 0 ? cartdto.getQuantity() : 0);
        cart.setName(!cartdto.getName().isEmpty() ? cartdto.getName() : null);
        return cartRepo.save(cart);
    }

    public List<Cart> getByCustomerID(Long id){
        List<Cart> listItems = cartRepo.getByCustomerId(id);
        List<Cart> result = new CopyOnWriteArrayList<>();
        List<Long> checkList = new ArrayList<>();
        List<Long> checkProductID = new ArrayList<>();
        List<Integer> indexaddedtoQue = new ArrayList<>();

        for (int i=0 ; i<=listItems.size()-1; i++){
            if (checkList.contains(listItems.get(i).getProductId()))
                continue;
            for (int j=0; j<=listItems.size()-1; j++){
                if (result.isEmpty()) {
                    result.add(listItems.get(i));
                    checkProductID.add(listItems.get(j).getProductId());
                    indexaddedtoQue.add(j);
                }
                else if (listItems.get(i).getProductId().equals(listItems.get(j).getProductId())) {
                    for (int k=0; k<=result.size()-1; k++){
                        if(!indexaddedtoQue.contains(j) && result.get(k).getProductId().equals(listItems.get(j).getProductId())){
                            result.get(k).setTotal_price(result.get(k).getTotal_price()+listItems.get(j).getTotal_price());
                            result.get(k).setQuantity(result.get(k).getQuantity()+listItems.get(j).getQuantity());
                            if (!checkList.contains(result.get(k).getProductId()))
                                checkList.add(result.get(k).getProductId());
                        }
                    }
                }else {
                    if (!checkProductID.contains(listItems.get(j).getProductId())) {
                        result.add(listItems.get(j));
                        checkProductID.add(listItems.get(j).getProductId());
                        indexaddedtoQue.add(j);
                    }
                }
            }
        }
        return result;
    }

    public Optional<Cart> getByCartId(Long id){
        return cartRepo.findById(id);
    }

}
