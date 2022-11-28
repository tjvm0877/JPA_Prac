package com.hyun.jpa_prac;

import com.hyun.jpa_prac.entity.Food;
import com.hyun.jpa_prac.entity.Member;
import com.hyun.jpa_prac.entity.Orders;
import com.hyun.jpa_prac.repository.FoodRepository;
import com.hyun.jpa_prac.repository.MemberRepository;
import com.hyun.jpa_prac.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Restaurant implements ApplicationRunner {

    private final FoodRepository foodRepository;
    private final OrdersRepository ordersRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Food> foods = new ArrayList<>();
        Food food1 = new Food("후라이드 치킨", 10000);
        foods.add(food1);
        Food food2 = new Food("양념치킨", 12000);
        foods.add(food2);
        Food food3 = new Food("반반치킨", 11000);
        foods.add(food3);
        Food food4 = new Food("갈비치킨", 13000);
        foods.add(food4);
        Food food5 = new Food("순살치킨", 13000);
        foods.add(food5);
        foodRepository.saveAll(foods);

        List<Member> members = new ArrayList<>();
        Member member1 = new Member("현");
        members.add(member1);
        Member member2 = new Member("김재");
        members.add(member2);
        memberRepository.saveAll(members);

        System.out.println("==================================================================");
        System.out.println("Member 데이터");
        List<Member> findMembers = memberRepository.findAll();
        for (Member findMember : findMembers) {
            System.out.println("findMember = " + findMember.getMemberName());
        }
        System.out.println("==================================================================");
        System.out.println("Food 데이터");
        List<Food> findFoods = foodRepository.findAll();
        for (Food findFood : findFoods) {
            System.out.println("findFood = " + findFood.getFoodName());
        }

        List<Orders> ordersList = new ArrayList<>();
        Orders orders1 = new Orders(findFoods.get(0), findMembers.get(0));
        ordersList.add(orders1);
        Orders orders2 = new Orders(findFoods.get(3), findMembers.get(1));
        ordersList.add(orders2);
        Orders orders3 = new Orders(findFoods.get(4), findMembers.get(1));
        ordersList.add(orders3);
        Orders orders4 = new Orders(findFoods.get(2), findMembers.get(0));
        ordersList.add(orders4);
        Orders orders5 = new Orders(findFoods.get(2), findMembers.get(0));
        ordersList.add(orders5);
        Orders orders6 = new Orders(findFoods.get(1), findMembers.get(1));
        ordersList.add(orders6);
        Orders orders7 = new Orders(findFoods.get(1), findMembers.get(0));
        ordersList.add(orders7);
        Orders orders8 = new Orders(findFoods.get(3), findMembers.get(1));
        ordersList.add(orders8);
        ordersRepository.saveAll(ordersList);
        System.out.println("==================================================================");

        int num = 1;
        System.out.println("Orders 데이터");
        List<Orders> orderList = ordersRepository.findAll();

        for (Orders orders : orderList) {
            System.out.println(num);
            System.out.println("주문한 사람 = " + orders.getMember().getMemberName());
            System.out.println("주문한 음식 = " + orders.getFood().getFoodName());
            num++;
        }

        System.out.println("==================================================================");
        System.out.println("현이 주문한 음식");
        Member hyun = memberRepository.findById(1L).orElseThrow(
                ()->new RuntimeException("없음")
        );

        num = 1;
        for (Orders orders : hyun.getOrders()) {
            System.out.println(num);
            System.out.println("주문한 음식 = " + orders.getFood().getFoodName());
            System.out.println("주문한 음식 가격 = " + orders.getFood().getPrice());
            num++;
        }

        System.out.println("==================================================================");
        System.out.println("순살 주문한 사람");
        Food noBone = foodRepository.findById(5L).orElseThrow(
                ()->new RuntimeException("없음")
        );
        for (Orders order : noBone.getOrders()) {
            System.out.println("주문한 사람 = " + order.getMember().getMemberName());
        }
    }
}
