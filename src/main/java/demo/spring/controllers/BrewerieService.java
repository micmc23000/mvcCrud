/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author michael
 */
@Service
public class BrewerieService {

    public static List<Breweries> getAllBreweries() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Breweries> tq = em.createNamedQuery("Breweries.findAll", Breweries.class);

        List<Breweries> breweriesList = new ArrayList<>();
        try {
            breweriesList = tq.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return breweriesList;
    }

    public void addAnBreweries(Breweries a) { //Insert new agent into DB
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public Breweries getBreweriesById(int id) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        TypedQuery<Breweries> tq = em.createNamedQuery("Breweries.findByBreweriesId", Breweries.class).setParameter("agentId", id);

        Breweries a = null;
        try {
            a = tq.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return a;
    }

    public void editBreweries(Breweries a) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(a);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public void deleteAnBreweries(int id) {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            Breweries item = getBreweriesById(id);
            transaction.begin();
            em.remove(em.merge(item));
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
}
