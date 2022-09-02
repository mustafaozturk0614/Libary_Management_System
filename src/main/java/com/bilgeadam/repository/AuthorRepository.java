package com.bilgeadam.repository;

import java.util.Optional;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bilgeadam.entity.Author;
import com.bilgeadam.utility.MyFactoryRepository;

public class AuthorRepository extends MyFactoryRepository<Author, Long> {

	public AuthorRepository() {
		super(new Author());

	}

	public Optional<Author> findbyFirstNameAndLAstName(String firstname, String lastName) {

		Author author = null;

		CriteriaQuery<Author> criteriaQuery = getCriteriaBuilder().createQuery(Author.class);
		Root<Author> root = criteriaQuery.from(Author.class);

		Predicate predicateFirtsNamePredicate = getCriteriaBuilder().equal(root.get("firstName"), firstname);
		Predicate predicateLastNamePredicate = getCriteriaBuilder().equal(root.get("lastName"), lastName);
		criteriaQuery.select(root)
				.where(getCriteriaBuilder().and(predicateFirtsNamePredicate, predicateLastNamePredicate));

		try {

			author = getEntityManager().createQuery(criteriaQuery).getSingleResult();

			return Optional.of(author);

		} catch (Exception e) {
			// TODO: handle exception
			return Optional.ofNullable(null);
		}

	}

}
