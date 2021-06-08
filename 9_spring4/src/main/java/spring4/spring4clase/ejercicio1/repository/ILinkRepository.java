package spring4.spring4clase.ejercicio1.repository;


import spring4.spring4clase.ejercicio1.domain.Link;
import spring4.spring4clase.ejercicio1.service.dto.LinkDTO;

import java.util.List;

public interface ILinkRepository {
   public List<Link> saveLink(Link link);
   public List<Link> showLink();
   public void setView(Link link, int view);
   public int getView(int linkid);
}
