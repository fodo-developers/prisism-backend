package team.underlive.underlive.domain.board.controller

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.underlive.underlive.domain.board.entity.dto.CreateBoardRequest
import team.underlive.underlive.domain.board.entity.dto.FetchBoardListResponse
import team.underlive.underlive.domain.board.entity.dto.FetchBoardResponse
import team.underlive.underlive.domain.board.service.BoardService

@RestController
@RequestMapping("/board")
class BoardController(
	private val boardService: BoardService,
) {
	@PostMapping
	fun createBoard(
		@RequestBody @Valid createBoardRequest: CreateBoardRequest,
	): ResponseEntity<Void> {
		boardService.createBoard(createBoardRequest)
		return ResponseEntity.ok().build()
	}

	@GetMapping
	fun fetchBoardList(): ResponseEntity<List<FetchBoardListResponse>> {
		return ResponseEntity.ok(boardService.fetchBoardList())
	}

	@GetMapping("/{id}")
	fun fetchBoard(
		@PathVariable id: String,
	): ResponseEntity<FetchBoardResponse> {
		return ResponseEntity.ok(boardService.fetchBoard(id.toLong()))
	}
}
