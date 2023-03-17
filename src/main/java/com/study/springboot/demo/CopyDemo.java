package com.study.springboot.demo;

/**
 * 深拷贝浅拷贝
 * @Author liuhao
 * @Date 2023/2/7
 */
public class CopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*Animal animal = new Animal();
        animal.setAge(18);

        animal.setName("dongwu");
        Dog dog = new Dog();
        dog.setName("dog");
        animal.setEat(dog);
        Animal animal2 = (Animal) animal.clone();

        JSONObject json = JSON.parseObject(JSON.toJSONString(animal));
        Animal animal1 = JSONObject.parseObject(JSON.toJSONString(animal),Animal.class);
        System.out.println("1111");*/
        /*Pattern p=Pattern.compile("\\d+");

        Matcher m=p.matcher("aaa2223bb");

        m.find();//匹配2223

        int i = m.start();//返回3

        m.end();//返回7,返回的是2223后的索引号

        String ddd = m.group();//返回2223
*/
        /*Pattern pattern = Pattern.compile("\\d+");
        Matcher m=pattern.matcher("aaa2223bb");
        String ss = m.group();
        System.out.println(ss);*/


        /*String questionDes = "122~200";
        String questionID ="10";
        String spilStr = "~";
        if(("10".equals(questionID)||"11".equals(questionID))){
            System.out.println(questionDes);
            String[] answers = questionDes.split(spilStr);
            if(null!=answers && answers.length>=2){
                StringBuilder questionDesNew = new StringBuilder();
                questionDesNew.append(new BigDecimal(answers[0]).setScale(3, BigDecimal.ROUND_HALF_UP).);
                questionDesNew.append(spilStr);
                questionDesNew.append(new BigDecimal(answers[1]).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                questionDes = questionDesNew.toString();
            }
            System.out.println(questionDes);*/
        }
    }
